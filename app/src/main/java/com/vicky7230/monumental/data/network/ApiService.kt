package com.vicky7230.monumental.data.network

import com.google.gson.JsonElement
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("auth/generateOTP")
    suspend fun getOTP(@Field("email") email: String): Response<JsonElement>

    @FormUrlEncoded
    @POST("auth/verifyOTP")
    suspend fun verifyOTP(
        @Field("email") email: String,
        @Field("otp") otp: String
    ): Response<JsonElement>
}