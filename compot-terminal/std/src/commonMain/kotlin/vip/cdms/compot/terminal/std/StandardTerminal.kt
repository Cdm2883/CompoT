package vip.cdms.compot.terminal.std

import vip.cdms.compot.terminal.api.*

object StandardTerminal : Terminal {
    override val width
        get() = getTerminalWidth0()
    override val height
        get() = getTerminalHeight0()

    override val signal = SignalEmitter().apply(::initStandardSignalHandler)
    override val io = StandardIO
    override val focus = StandardFocus
    override val mouse = StandardMouse

    override val env = StandardEnv
    override val palette = StandardPalette
}

expect fun getTerminalWidth0(): Int
expect fun getTerminalHeight0(): Int

internal expect fun initStandardSignalHandler(signal: SignalEmitter)
