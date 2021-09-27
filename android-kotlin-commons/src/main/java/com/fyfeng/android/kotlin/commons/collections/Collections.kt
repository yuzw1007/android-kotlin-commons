package com.fyfeng.android.kotlin.commons.collections


fun <T> List<T>?.emptyToNull(): List<T>? {
    return this?.let {
        if (it.isEmpty()) null else it
    }
}

//-----------------------------------------------------------------------
fun <T> List<T>?.partition(size: Int): List<List<T>> {
    if (this == null) {
        throw NullPointerException("List must not be null")
    }
    require(size > 0) { "Size must be greater than 0" }
    return ListPartition(this, size)
}