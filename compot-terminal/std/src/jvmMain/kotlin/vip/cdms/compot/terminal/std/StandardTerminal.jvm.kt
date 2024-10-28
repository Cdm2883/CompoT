package vip.cdms.compot.terminal.std

import org.jline.terminal.Terminal
import org.jline.terminal.TerminalBuilder
import vip.cdms.compot.terminal.api.Signal
import vip.cdms.compot.terminal.api.SignalEmitter

val SystemTerminal by lazy {
    TerminalBuilder.builder()
        .system(true)
        .build()!!
}

actual fun getTerminalWidth0() = SystemTerminal.width
actual fun getTerminalHeight0() = SystemTerminal.height

private typealias JSignal = Terminal.Signal
internal actual fun initStandardSignalHandler(signal: SignalEmitter) {
    SystemTerminal.handle(JSignal.INT) { signal.raise(Signal.INT) }
    SystemTerminal.handle(JSignal.QUIT) { signal.raise(Signal.QUIT) }
    SystemTerminal.handle(JSignal.TSTP) { signal.raise(Signal.TSTP) }
    SystemTerminal.handle(JSignal.CONT) { signal.raise(Signal.CONT) }
    SystemTerminal.handle(JSignal.WINCH) { signal.raise(Signal.WINCH) }
}
