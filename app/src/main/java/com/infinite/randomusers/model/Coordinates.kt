package com.infinite.randomusers.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Coordinates(
    @Json(name = "latitude")
    val latitude: String,
    @Json(name = "longitude")
    val longitude: String
): Parcelable