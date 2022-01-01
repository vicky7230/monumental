package com.vicky7230.monumental.data.network

import com.google.gson.JsonElement
import retrofit2.Response

interface ApiHelper {
    suspend fun getNews(): Response<JsonElement>
}