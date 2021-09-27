package com.fyfeng.android.kotlin.commons.io

import java.io.Closeable

fun Closeable?.closeQuietly() {
    if (null == this) return
    try {
        this.close()
    } catch (t: Throwable) {
        // do nothing
    }
}