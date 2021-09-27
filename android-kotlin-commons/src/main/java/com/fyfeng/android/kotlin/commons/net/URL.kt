package com.fyfeng.android.kotlin.commons.net

import android.util.Log
import com.fyfeng.android.kotlin.commons.io.toFile
import java.io.File
import java.net.URL

private const val TAG = "URL"

fun String?.toURLGetFileName(): String? {
    return this?.let {
        try {
            File(URL(this).path).name
        } catch (e: Exception) {
            null
        }
    }
}

fun String.toURLToFileQuietly(destFile: File): Boolean {
    return toURLToFileQuietly(destFile, 0, 0)
}

fun String.toURLToFileQuietly(destFile: File, connectionTimeout: Int, readTimeout: Int): Boolean {
    return try {
        this.toURLToFile(destFile, connectionTimeout, readTimeout)
        true
    } catch (e: Exception) {
        Log.e(TAG, "toURLToFileQuietly", e)
        false
    }
}

fun String.toURLToFile(destFile: File) {
    this.toURLToFile(destFile, 0, 0)
}

fun String.toURLToFile(destFile: File, connectionTimeout: Int, readTimeout: Int) {
    URL(this).toFile(destFile, connectionTimeout, readTimeout)
}

fun URL.toFileQuietly(destFile: File): Boolean {
    return toFileQuietly(destFile, 0, 0)
}

fun URL.toFile(destFile: File) {
    this.toFile(destFile, 0, 0)
}

fun URL.toFileQuietly(destFile: File, connectionTimeout: Int, readTimeout: Int): Boolean {
    return try {
        this.toFile(destFile, connectionTimeout, readTimeout)
        true
    } catch (e: Exception) {
        Log.e(TAG, "toFileQuietly", e)
        false
    }
}

fun URL.toFile(destFile: File, connectionTimeout: Int, readTimeout: Int) {
    val connection = this.openConnection()
    connection.connectTimeout = connectionTimeout
    connection.readTimeout = readTimeout
    connection.getInputStream().use {
        it.toFile(destFile)
    }
}

fun String.toURLToFileToDirectory(
    directory: File,
    connectionTimeout: Int,
    readTimeout: Int
): File? {
    val filename = this.toURLGetFileName() ?: return null
    val destFile = File(directory, filename)
    this.toURLToFile(destFile, connectionTimeout, readTimeout)
    return destFile
}

fun String.toURLToFileToDirectory(directory: File): File? {
    val filename = this.toURLGetFileName() ?: return null
    val destFile = File(directory, filename)
    this.toURLToFile(destFile)
    return destFile
}

fun String.toURLToFileToDirectoryQuietly(
    directory: File,
    connectionTimeout: Int,
    readTimeout: Int
): File? {
    return try {
        this.toURLToFileToDirectory(directory, connectionTimeout, readTimeout)
    } catch (e: Exception) {
        Log.e(TAG, "toURLToFileToDirectoryQuietly", e)
        null
    }
}

fun String.toURLToFileToDirectoryQuietly(directory: File): File? {
    return this.toURLToFileToDirectoryQuietly(directory, 0, 0)
}