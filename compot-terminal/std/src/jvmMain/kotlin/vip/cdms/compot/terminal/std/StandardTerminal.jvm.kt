package vip.cdms.compot.terminal.std

import org.jline.terminal.TerminalBuilder

val SystemTerminal by lazy {
    TerminalBuilder.builder()
        .system(true)
        .build()!!
}

actual fun getTerminalWidth0() = SystemTerminal.width
actual fun getTerminalHeight0() = SystemTerminal.height
