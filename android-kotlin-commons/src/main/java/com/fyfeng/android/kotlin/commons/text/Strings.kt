package com.fyfeng.android.kotlin.commons.text

fun <T : CharSequence> isNoneBlank(vararg css: T?): Boolean {
    return !isAnyBlank(*css)
}

fun <T : CharSequence> isAnyBlank(vararg css: T?): Boolean {
    if (css.isEmpty()) {
        return false
    }
    for (str in css) {
        if (str.isNullOrBlank()) {
            return true
        }
    }
    return false
}