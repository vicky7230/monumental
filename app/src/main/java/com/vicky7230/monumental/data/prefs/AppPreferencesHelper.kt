package com.vicky7230.monumental.data.prefs

/**
 * Created by vicky on 1/3/18.
 */

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager


class AppPreferencesHelper(context: Context) : PreferencesHelper {

    private val PREF_KEY_USER_LOGGED_IN = "PREF_KEY_USER_LOGGED_IN"

    private val sharedPreferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)


    override fun isUserLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(PREF_KEY_USER_LOGGED_IN, false)
    }

    override fun setUserLoggedIn() {
        sharedPreferences.edit().putBoolean(PREF_KEY_USER_LOGGED_IN, true).apply()
    }

    override fun setUserLoggedOut() {
        sharedPreferences.edit {
            remove(PREF_KEY_USER_LOGGED_IN)
        }
    }
}