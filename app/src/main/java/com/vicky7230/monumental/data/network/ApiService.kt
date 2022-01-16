package com.vicky7230.monumental.data.network

import com.google.gson.JsonElement
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("auth/generateOTP")
    suspend fun getOTP(): Response<JsonElement>
}