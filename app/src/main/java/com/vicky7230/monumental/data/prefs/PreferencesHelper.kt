package com.vicky7230.monumental.data.prefs

/**
 * Created by vicky on 1/3/18.
 */
interface PreferencesHelper {

    fun isUserLoggedIn(): Boolean

    fun setUserLoggedIn()

    fun setUserLoggedOut()
}