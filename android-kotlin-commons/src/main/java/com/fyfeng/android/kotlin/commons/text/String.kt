package com.fyfeng.android.kotlin.commons.text

import android.util.Base64
import java.nio.charset.StandardCharsets

fun String.toBase64Utf8String(): String? {
    return Base64.encodeToString(this.toByteArray(StandardCharsets.UTF_8), Base64.DEFAULT)
}

fun String?.stringToInt(): Int {
    return this.stringToInt(0)
}

fun String?.stringToInt(defaultValue: Int): Int {
    return this?.let {
        try {
            this.toInt()
        } catch (nfe: NumberFormatException) {
            defaultValue
        }
    } ?: defaultValue
}

fun <T : CharSequence> T?.blankToNull(): T? {
    return if (this.isNullOrBlank()) null else this
}

fun <T : CharSequence> T?.emptyToNull(): T? {
    return if (this.isNullOrEmpty()) null else this
}

fun CharSequence?.trimToNull(): CharSequence? {
    val value = this?.trim()
    return if (!value.isNullOrEmpty()) value else null
}

fun CharSequence?.trimToEmpty(): CharSequence {
    val value = this?.trim()
    return if (!value.isNullOrEmpty()) value else ""
}

fun String?.trimToNull(): String? = (this as CharSequence).trimToNull()?.let { it as String }
fun String?.trimToEmpty(): String = (this as CharSequence).trimToEmpty() as String

fun CharSequence?.nullToEmpty(): CharSequence = this ?: ""

fun String?.nullToEmpty(): String = (this as CharSequence).nullToEmpty() as String

fun CharSequence?.nullOrBlankToEmpty(): CharSequence = if (!this.isNullOrBlank()) this else ""

fun String?.nullOrBlankToEmpty(): String = (this as CharSequence).nullOrBlankToEmpty() as String