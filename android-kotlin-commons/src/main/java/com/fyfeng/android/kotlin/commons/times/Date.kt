package com.fyfeng.android.kotlin.commons.times

import java.text.SimpleDateFormat
import java.util.*


fun Date.format(pattern: String): String {
    val dateFormat = SimpleDateFormat(pattern, Locale.CHINA)
    return dateFormat.format(this)
}

fun Long.format(pattern: String): String {
    return Date(this).format(pattern)
}

fun Date?.isSameDay(date: Date?): Boolean {
    if (null == date || null == this) {
        return false
    }

    val cal1 = Calendar.getInstance()
    cal1.time = this
    val cal2 = Calendar.getInstance()
    cal2.time = date

    return cal1[Calendar.ERA] == cal2[Calendar.ERA] && cal1[Calendar.YEAR] == cal2[Calendar.YEAR] && cal1[Calendar.DAY_OF_YEAR] == cal2[Calendar.DAY_OF_YEAR]
}

fun Date.add(calendarField: Int, amount: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.add(calendarField, amount)
    return calendar.time
}

fun Date.plusMillis(millisToAdd: Int): Date {
    return add(Calendar.MILLISECOND, millisToAdd)
}

fun Date.plusSeconds(secondsToAdd: Int): Date {
    return add(Calendar.SECOND, secondsToAdd)
}

fun Date.plusMinutes(minutesToAdd: Int): Date {
    return add(Calendar.MINUTE, minutesToAdd)
}

fun Date.plusHours(hoursToAdd: Int): Date {
    return add(Calendar.HOUR_OF_DAY, hoursToAdd)
}

fun Date.plusDays(daysToAdd: Int): Date {
    return add(Calendar.DAY_OF_MONTH, daysToAdd)
}

fun Date.plusWeeks(weeksToAdd: Int): Date {
    return add(Calendar.WEEK_OF_YEAR, weeksToAdd)
}

fun Date.plusMonths(monthsToAdd: Int): Date {
    return add(Calendar.MONTH, monthsToAdd)
}

fun Date.plusYears(yearsToAdd: Int): Date {
    return add(Calendar.YEAR, yearsToAdd)
}

fun Date.minusMillis(millisToSubtract: Int): Date {
    return this.plusMillis(-millisToSubtract)
}

fun Date.minusSeconds(secondsToSubtract: Int): Date {
    return this.plusSeconds(-secondsToSubtract)
}

fun Date.minusMinutes(minutesToSubtract: Int): Date {
    return this.plusMinutes(-minutesToSubtract)
}

fun Date.minusHours(hoursToSubtract: Int): Date {
    return this.plusHours(-hoursToSubtract)
}

fun Date.minusDays(daysToSubtract: Int): Date {
    return this.plusDays(-daysToSubtract)
}

fun Date.minusWeeks(weeksToSubtract: Int): Date {
    return this.plusWeeks(-weeksToSubtract)
}

fun Date.minusMonths(monthsToSubtract: Int): Date {
    return this.plusMonths(-monthsToSubtract)
}

fun Date.minusYears(yearsToSubtract: Int): Date {
    return this.plusYears(-yearsToSubtract)
}