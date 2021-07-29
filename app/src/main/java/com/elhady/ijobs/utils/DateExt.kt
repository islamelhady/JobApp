package com.elhady.ijobs.utils

import java.text.SimpleDateFormat
import java.util.*

const val YEAR_MONTH_DAY_T_TIME = "yyyy-MM-dd'T'HH:mm:ss"
const val YEAR_MONTH_DAY = "yyyy-MM-dd"
const val HOUR_MINUTE_SECONDS = "HH:mm:ss"
const val DAY_MONTH = "dd/MM"
const val DAY_MONTH_YEAR = "dd/MM/yyyy"
const val DAY_MONTH_YEAR_HOUR_MIN = "dd/MM/yyyy  h:mm a"
const val HOUR_MINUTES_AM = "h:mm a"
const val DAY_FULL_MONTH_YEAR = "dd MMMM yyyy"
const val DAY_DAY_FULL_MONTH_YEAR = "EEEE dd MMMM yyyy"

fun Date.format(pattern: String, locale: Locale = Locale.ENGLISH): String? {
    return SimpleDateFormat(pattern, locale).format(this)
}

fun String.toDateFormatted(oldPattern: String, newPattern: String,local : Locale ?= Locale.ENGLISH): String {
    val sdf = SimpleDateFormat(oldPattern, Locale.ENGLISH)
    val date = sdf.parse(this)
    val localizedSimpleDateFormat = SimpleDateFormat(newPattern,local)
    return localizedSimpleDateFormat.format(date!!)
}
