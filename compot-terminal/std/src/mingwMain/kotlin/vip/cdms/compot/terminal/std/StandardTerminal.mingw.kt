package vip.cdms.compot.terminal.std

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import platform.windows.*

@OptIn(ExperimentalForeignApi::class)
fun getConsoleScreenBufferInfo(): CONSOLE_SCREEN_BUFFER_INFO {
    val hConsole = GetStdHandle(STD_OUTPUT_HANDLE)
        .takeUnless { it == INVALID_HANDLE_VALUE } ?: throw Error("Unable to get console handle")
    memScoped {
        val screenBufferInfo = alloc<CONSOLE_SCREEN_BUFFER_INFO>()
        if (GetConsoleScreenBufferInfo(hConsole, screenBufferInfo.ptr) == 0) throw Error("Unable to get console screen buffer")
        return screenBufferInfo
    }
}

actual fun getTerminalWidth0() = getConsoleScreenBufferInfo().run {
    srWindow.Right - srWindow.Left + 1
}

actual fun getTerminalHeight0() = getConsoleScreenBufferInfo().run {
    srWindow.Bottom - srWindow.Top + 1
}
