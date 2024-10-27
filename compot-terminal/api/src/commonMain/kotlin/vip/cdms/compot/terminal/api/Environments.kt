package vip.cdms.compot.terminal.api

interface Environments {
    operator fun get(key: String): String?
    operator fun set(key: String, value: String)
}
