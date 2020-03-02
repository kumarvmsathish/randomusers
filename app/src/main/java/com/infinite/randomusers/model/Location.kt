package com.infinite.randomusers.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Location(
    @Json(name = "city")
    val city: String,
    @Json(name = "coordinates")
    val coordinates: Coordinates,
    @Json(name = "country")
    val country: String,
    @Json(name = "postcode")
    val postcode: String,
    @Json(name = "state")
    val state: String,
    @Json(name = "street")
    val street: Street,
    @Json(name = "timezone")
    val timezone: Timezone
): Parcelable