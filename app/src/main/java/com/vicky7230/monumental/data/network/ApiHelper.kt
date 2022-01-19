package com.vicky7230.monumental.data.network

import com.google.gson.JsonElement
import retrofit2.Response
import retrofit2.http.Field

interface ApiHelper {
    suspend fun getOTP(email: String): Response<JsonElement>

    suspend fun verifyOTP(email: String, otp: String): Response<JsonElement>
}