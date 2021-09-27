package com.fyfeng.android.kotlin.commons.io

import android.util.Log
import java.io.File
import java.io.InputStream

private const val TAG = "File"

fun InputStream.toFile(file: File) {
    file.outputStream().use {
        this.copyTo(it)
    }
}

fun File?.deleteQuietly() {
    this?.let {
        try {
            this.deleteRecursively()
        } catch (ignored: Exception) {
        }
    }
}

fun File?.isExists(): Boolean {
    return null != this && this.exists()
}

fun File?.isNotExists(): Boolean {
    return !this.isExists()
}

fun String?.toFileIsExists(): Boolean {
    return !this.isNullOrBlank() && File(this).exists()
}

fun String?.toExistsFileOrNull(): File? {
    return this?.let {
        val file = File(this)
        if (file.exists()) file else null
    }
}

fun File?.notExistsToNull(): File? {
    if (this.isNotExists()) return null
    return this
}

fun File?.moveToDirectory(directory: File?, createDir: Boolean): File? {
    if (null == this || null == directory || this.isNotExists()) {
        return null
    }

    if (!directory.exists() && createDir) {
        directory.mkdirs()
    }
    val destFile = File(directory, name)
    if (this.renameTo(destFile)) {
        return destFile
    }

    try {
        this.copyTo(destFile)
    } catch (e: Exception) {
        destFile.deleteQuietly()
        return null
    }

    if (this.delete()) {
        return destFile
    }

    destFile.deleteQuietly()
    return null
}

fun File.copyToDirectory(dir: File): File? {
    return this.copyToDirectory(dir, true)
}

fun File.copyToDirectory(dir: File, createDir: Boolean): File? {
    if (!exists()) {
        return null
    }

    if (!dir.exists() && createDir) {
        dir.mkdirs()
    }
    val destFile = File(dir, name)
    if (destFile.exists()) {
        destFile.deleteQuietly()
    }
    return try {
        this.copyTo(destFile)
    } catch (e: Exception) {
        null
    }
}

fun File.createChildFile(filename: String): Boolean {
    if (!this.isDirectory) {
        return false
    }
    if (!this.exists()) {
        if (!this.mkdirs()) {
            return false
        }
    }
    val destFile = File(this, filename)
    if (destFile.exists()) {
        destFile.deleteQuietly()
    }
    return try {
        destFile.createNewFile()
    } catch (e: Exception) {
        Log.e(TAG, "createChildFile", e)
        false
    }
}