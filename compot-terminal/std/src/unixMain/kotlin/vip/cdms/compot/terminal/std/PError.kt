package vip.cdms.compot.terminal.std

import platform.posix.perror

class PError(message: String?) : Error(message) {
    init {
        perror(message)
    }
}
