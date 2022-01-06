package com.vicky7230.monumental.ui._1splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.vicky7230.monumental.R
import com.vicky7230.monumental.extensions.StatusIconColorType
import com.vicky7230.monumental.extensions.setStatusBarAndNavigationBarColor
import com.vicky7230.monumental.ui._2onboarding.OnboardActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashActivity : AppCompatActivity() {

    private val mainViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setStatusBarAndNavigationBarColor(ContextCompat.getColor(this,R.color.sky), StatusIconColorType.Dark)

        lifecycleScope.launch {
            delay(2000)
            startActivity(Intent(this@SplashActivity, OnboardActivity::class.java))
            finish()
        }
    }
}