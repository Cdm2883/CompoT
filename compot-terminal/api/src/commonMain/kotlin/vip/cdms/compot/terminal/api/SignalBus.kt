package vip.cdms.compot.terminal.api

typealias Signal = SignalBus.Signal

interface SignalBus {
    enum class Signal {
        /**
         * **Interrupt signal**, usually triggered by pressing `Ctrl+C`.
         * This signal is commonly used to safely terminate the current process.
         */
        INT,

        /**
         * **Quit signal**, typically triggered by pressing `Ctrl+\`.
         * Requests the immediate termination of the process, potentially creating a core dump for debugging purposes.
         */
        QUIT,

        /**
         * **Terminal stop signal**, generally triggered by pressing `Ctrl+Z`.
         * Suspends (pauses) the current process, which can be resumed later.
         */
        TSTP,

        /**
         * **Continue signal**. Used to resume a process that was previously suspended by a TSTP signal.
         */
        CONT,

        /**
         * **Window change signal**. Sent by the terminal when the window size changes,
         */
        WINCH
    }

    fun handle(signal: Signal, callback: () -> Unit)
}

// Kotlin Flow is not supported for **ALL** targets
class SignalEmitter : SignalBus {
    val listeners = mutableListOf<(signal: Signal) -> Unit>()

    fun raise(signal: Signal) = listeners.forEach { it(signal) }

    override fun handle(signal: Signal, callback: () -> Unit) {
        listeners += { if (it == signal) callback() }
    }
    fun handles(vararg signals: Signal, callback: (signal: Signal) -> Unit) {
        listeners += { if (it in signals) callback(it) }
    }
}
