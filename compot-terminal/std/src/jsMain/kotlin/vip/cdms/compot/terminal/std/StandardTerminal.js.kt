package vip.cdms.compot.terminal.std

import node.process.process

actual fun getTerminalWidth0() = process.stdout.rows.toInt()
actual fun getTerminalHeight0() = process.stdout.columns.toInt()
