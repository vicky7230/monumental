package com.vicky7230.monumental.di

import com.vicky7230.monumental.data.AppDataManager
import com.vicky7230.monumental.data.DataManager
import com.vicky7230.monumental.data.db.AppDatabase
import com.vicky7230.monumental.data.db.AppDbHelper
import com.vicky7230.monumental.data.network.AppApiHelper
import com.vicky7230.monumental.data.prefs.AppPreferencesHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single { AppDatabase.getInstance(androidContext().applicationContext) }
    single { AppApiHelper(get()) }
    single { AppDbHelper(get()) }
    single { AppPreferencesHelper(get()) }
    single<DataManager> { AppDataManager(get(), get(), get()) as DataManager }
}
