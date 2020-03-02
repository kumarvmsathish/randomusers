package com.infinite.randomusers.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Registered(
    @Json(name = "age")
    val age: Int,
    @Json(name = "date")
    val date: String
): Parcelable