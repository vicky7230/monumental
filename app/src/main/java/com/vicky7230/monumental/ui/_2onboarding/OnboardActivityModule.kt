package com.vicky7230.monumental.ui._2onboarding

import com.vicky7230.monumental.ui._1splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val onboardActivityModule = module {

    factory { OnboardAdapter(mutableListOf()) }

}