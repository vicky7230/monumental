package com.vicky7230.monumental.data.network

import com.google.gson.JsonElement
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "dffb063c4fb04b9492497adce8b7aea6"
    ): Response<JsonElement>
}