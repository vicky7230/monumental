package com.vicky7230.monumental.data

import com.google.gson.JsonElement
import com.vicky7230.monumental.data.db.AppDbHelper
import com.vicky7230.monumental.data.db.entity.User
import com.vicky7230.monumental.data.network.AppApiHelper
import com.vicky7230.monumental.data.prefs.AppPreferencesHelper
import retrofit2.Response

class AppDataManager(
    private val appApiHelper: AppApiHelper,
    private val appDbHelper: AppDbHelper,
    private val appPreferencesHelper: AppPreferencesHelper
) : DataManager {
    override suspend fun getOTP(email: String): Response<JsonElement> {
        return appApiHelper.getOTP(email)
    }

    override suspend fun verifyOTP(email: String, otp: String): Response<JsonElement> {
        return  appApiHelper.verifyOTP(email, otp)
    }

    override suspend fun insertUser(user: User): Long {
        return appDbHelper.insertUser(user)
    }

    override fun isUserLoggedIn(): Boolean {
        return appPreferencesHelper.isUserLoggedIn()
    }

    override fun setUserLoggedIn() {
        return appPreferencesHelper.setUserLoggedIn()
    }

    override fun setUserLoggedOut() {
        return appPreferencesHelper.setUserLoggedOut()
    }

}