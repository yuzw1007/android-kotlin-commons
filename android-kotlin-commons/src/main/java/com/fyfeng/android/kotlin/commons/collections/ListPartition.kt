package com.fyfeng.android.kotlin.commons.collections

import java.util.*
import kotlin.math.ceil

class ListPartition<T>(private val list: List<T>, private val count: Int) :
    AbstractList<MutableList<T>>() {
    override fun get(index: Int): MutableList<T> {
        val listSize = size
        if (index < 0) {
            throw IndexOutOfBoundsException("Index $index must not be negative")
        }
        if (index >= listSize) {
            throw IndexOutOfBoundsException(
                "Index " + index + " must be less than size " +
                        listSize
            )
        }
        val start = index * count
        val end = (start + count).coerceAtMost(list.size)
        val data = list.subList(start, end)
        val result: MutableList<T> = arrayListOf()
        result.addAll(data)
        return result
    }

    override val size: Int
        get() = ceil(list.size.toDouble() / count.toDouble()).toInt()

    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }
}