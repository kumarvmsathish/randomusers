package com.infinite.randomusers.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Street(
    @Json(name = "name")
    val name: String,
    @Json(name = "number")
    val number: Int
): Parcelable