package com.vicky7230.monumental.data.network

import com.google.gson.JsonElement
import retrofit2.Response


class AppApiHelper constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getOTP(email: String): Response<JsonElement> {
        return apiService.getOTP(email)
    }

    override suspend fun verifyOTP(email: String, otp: String): Response<JsonElement> {
       return  apiService.verifyOTP(email, otp)
    }

}