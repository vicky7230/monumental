package com.vicky7230.monumental.ui._1splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vicky7230.monumental.data.DataManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel(private val dataManager: DataManager) : ViewModel() {

    fun getNews() {
        viewModelScope.launch(Dispatchers.IO) {
            dataManager.getNews()
        }
    }

}