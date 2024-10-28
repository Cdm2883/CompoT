package vip.cdms.compot.terminal.api

typealias Signal = SignalBus.Signal

interface SignalBus {
    enum class Signal {
        INT,
        QUIT,
        TSTP,
        CONT,
        INFO,
        WINCH
    }

    fun handle(signal: Signal, callback: () -> Unit)
}

// Kotlin Flow is not supported for **ALL** targets
class SignalEmitter : SignalBus {
    val listeners = mutableListOf<(signal: Signal) -> Unit>()

    fun emit(signal: Signal) = listeners.forEach { it(signal) }

    override fun handle(signal: Signal, callback: () -> Unit) {
        listeners += { if (it == signal) callback() }
    }
    fun handles(vararg signals: Signal, callback: (signal: Signal) -> Unit) {
        listeners += { if (it in signals) callback(it) }
    }
}
