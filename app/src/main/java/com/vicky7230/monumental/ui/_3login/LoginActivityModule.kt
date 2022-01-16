package com.vicky7230.monumental.ui._3login

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginActivityModule = module {

     viewModel { LoginViewModel(get()) }

 }