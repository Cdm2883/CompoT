package vip.cdms.compot.terminal.std

import kotlinx.cinterop.*
import platform.posix.*
import vip.cdms.compot.terminal.api.Signal
import vip.cdms.compot.terminal.api.SignalEmitter

@OptIn(ExperimentalForeignApi::class)
fun getWinSize() = memScoped {
    val winSize = alloc<winsize>()
    if (ioctl(STDOUT_FILENO, TIOCGWINSZ.convert(), winSize.ptr) == -1) throw PError("Unable to get terminal size")
    winSize
}

actual fun getTerminalWidth0() = getWinSize().ws_col.toInt()
actual fun getTerminalHeight0() = getWinSize().ws_row.toInt()

@OptIn(ExperimentalForeignApi::class)
internal actual fun initStandardSignalHandler(signal: SignalEmitter) {
    signal(SIGINT, staticCFunction { _: Int -> signal.raise(Signal.INT) })
    signal(SIGQUIT, staticCFunction { _: Int -> signal.raise(Signal.QUIT) })
    signal(SIGTSTP, staticCFunction { _: Int -> signal.raise(Signal.TSTP) })
    signal(SIGCONT, staticCFunction { _: Int -> signal.raise(Signal.CONT) })
    signal(SIGWINCH, staticCFunction { _: Int -> signal.raise(Signal.WINCH) })
}
