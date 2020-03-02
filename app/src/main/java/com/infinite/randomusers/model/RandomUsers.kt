package com.infinite.randomusers.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RandomUsers(
    @Json(name = "info")
    val info: Info,
    @Json(name = "results")
    val results: List<User>
)