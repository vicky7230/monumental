package com.vicky7230.monumental.ui._1splash

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashActivityModule = module {

    viewModel { SplashViewModel(get()) }

}