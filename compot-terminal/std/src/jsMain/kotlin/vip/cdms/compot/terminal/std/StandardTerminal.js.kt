package vip.cdms.compot.terminal.std

import node.process.Signals
import node.process.process
import vip.cdms.compot.terminal.api.Signal
import vip.cdms.compot.terminal.api.SignalEmitter

actual fun getTerminalWidth0() = process.stdout.rows.toInt()
actual fun getTerminalHeight0() = process.stdout.columns.toInt()

internal actual fun initStandardSignalHandler(signal: SignalEmitter) {
    process.on(Signals.SIGINT) { signal.raise(Signal.INT) }
    process.on(Signals.SIGQUIT) { signal.raise(Signal.QUIT) }
    process.on(Signals.SIGTSTP) { signal.raise(Signal.TSTP) }
    process.on(Signals.SIGCONT) { signal.raise(Signal.CONT) }
    process.on(Signals.SIGWINCH) { signal.raise(Signal.WINCH) }
}
