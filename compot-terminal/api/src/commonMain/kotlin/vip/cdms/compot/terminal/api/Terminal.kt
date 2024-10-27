package vip.cdms.compot.terminal.api

interface Terminal {
    val width: Int
    val height: Int

    val signal: SignalRegistrar
    val io: InputOutput
    val focus: FocusTracking
    val mouse: MouseManager

    val env: Environments
    val palette: ColorPalette
}
