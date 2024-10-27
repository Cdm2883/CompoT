package vip.cdms.compot.terminal.api

inline fun Terminal.getEnv(name: String) = env[name]

inline fun Terminal.handle(vararg signals: Signal, crossinline callback: (signal: Signal) -> Unit) = signals.forEach {
    signal.handle(it) { callback(it) }
}
