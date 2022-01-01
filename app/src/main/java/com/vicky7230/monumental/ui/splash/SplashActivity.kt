package com.vicky7230.monumental.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vicky7230.monumental.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val mainViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mainViewModel.getNews()

    }
}