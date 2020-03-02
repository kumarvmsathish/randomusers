package com.infinite.randomusers.network

import com.infinite.randomusers.model.RandomUsers
import com.infinite.randomusers.utils.NO_RECORDS_PER_REQUEST
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("api/")
    fun getDoctorHomeDetailsAsync(@Query("exc") excludedData: String = "login" ,
                                  @Query("format") format: String = "pretty",
                                  @Query("page") page: Int = 1,
                                  @Query("results") numberOfData: Int = NO_RECORDS_PER_REQUEST): Deferred<RandomUsers?>
}
