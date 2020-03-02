package com.infinite.randomusers.utils

import android.annotation.SuppressLint
import android.util.Log
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun formatDate(dateStr: String): String {

    return try {
        val parser = SimpleDateFormat(DATE_FORMAT_IN_API)
        val formatter = SimpleDateFormat(DATE_FORMAT_DD_MMM_YYYY_HH_MM_A)
        formatter.format(parser.parse(dateStr))
    } catch (e: Exception) {
        Log.e("Date format error", e.localizedMessage)
        dateStr
    }

}
