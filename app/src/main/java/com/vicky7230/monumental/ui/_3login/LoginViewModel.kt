package com.vicky7230.monumental.ui._3login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vicky7230.monumental.data.DataManager
import com.vicky7230.monumental.data.network.Resource
import kotlinx.coroutines.Dispatchers
import timber.log.Timber

class LoginViewModel(private val dataManager: DataManager) : ViewModel() {

    fun getOTP(email: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {

            val response = dataManager.getOTP(email)

            if (response.isSuccessful) {
                if (response.body()?.asJsonObject?.get("success")?.asBoolean!!) {
                    emit(Resource.success(response))
                } else {
                    emit(
                        Resource.error(
                            data = null,
                            message = response.body()?.asJsonObject?.get("message")?.asString!!
                        )
                    )
                }
            } else {
                emit(Resource.error(data = null, message = "Something went wrong"))
            }
        } catch (exception: Exception) {
            Timber.e(exception)
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun verifyOTP(email: String, otp: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val response = dataManager.verifyOTP(email, otp)
        } catch (exception: Exception) {
            Timber.e(exception)
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}