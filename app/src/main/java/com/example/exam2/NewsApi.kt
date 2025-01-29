package com.example.exam2

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("news")
    suspend fun getNewsDetails(
        @Query("access_key") apiKey: String = Constants.API_KEY,
        @Query("sources") sources: String,
        @Query("countries") countries: String,
    ): NewsEntity
}