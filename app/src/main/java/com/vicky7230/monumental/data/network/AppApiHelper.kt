package com.vicky7230.monumental.data.network

import com.google.gson.JsonElement
import retrofit2.Response


class AppApiHelper constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getOTP(): Response<JsonElement> {
        return apiService.getOTP()
    }

}