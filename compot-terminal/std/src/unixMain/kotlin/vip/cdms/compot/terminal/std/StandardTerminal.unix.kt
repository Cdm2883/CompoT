package vip.cdms.compot.terminal.std

import kotlinx.cinterop.*
import platform.posix.*

@OptIn(ExperimentalForeignApi::class)
fun getWinSize() = memScoped {
    val winSize = alloc<winsize>()
    if (ioctl(STDOUT_FILENO, TIOCGWINSZ.convert(), winSize.ptr) == -1) throw PError("Unable to get terminal size")
    winSize
}

actual fun getTerminalWidth0() = getWinSize().ws_col.toInt()
actual fun getTerminalHeight0() = getWinSize().ws_row.toInt()
