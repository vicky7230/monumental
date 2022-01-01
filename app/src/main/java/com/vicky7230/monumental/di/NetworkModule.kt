package com.vicky7230.monumental.di

import com.vicky7230.monumental.data.Config
import com.vicky7230.monumental.data.network.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { createRetrofitApiService() }
}

fun createRetrofitApiService(): ApiService {

    val httpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val disableCache = Interceptor { chain ->
        val original = chain.request()
        val requestBuilder = original.newBuilder()
            .header("cache-control", "no-cache")
        val request = requestBuilder.build()
        chain.proceed(request)
    }

    val retrofit = Retrofit.Builder()
        .baseUrl(Config.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .readTimeout(10 * 1000, TimeUnit.MILLISECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(disableCache)
                .build()
        )
        .build()

    return retrofit.create(ApiService::class.java)
}