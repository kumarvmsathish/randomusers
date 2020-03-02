package com.infinite.randomusers.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Id(
    @Json(name = "name")
    val name: String,
    @Json(name = "value")
    val value: String?
): Parcelable