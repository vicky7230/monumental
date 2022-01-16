package com.vicky7230.monumental.ui._3login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vicky7230.monumental.data.DataManager
import com.vicky7230.monumental.data.network.Resource
import kotlinx.coroutines.Dispatchers
import timber.log.Timber

class LoginViewModel (private val dataManager: DataManager) : ViewModel() {

    fun getOTP() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = dataManager.getOTP()))
        } catch (exception: Exception) {
            Timber.e(exception)
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}