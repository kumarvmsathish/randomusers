package com.infinite.randomusers.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Timezone(
    @Json(name = "description")
    val description: String,
    @Json(name = "offset")
    val offset: String
): Parcelable