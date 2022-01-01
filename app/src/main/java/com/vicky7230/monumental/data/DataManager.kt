package com.vicky7230.monumental.data

import com.vicky7230.monumental.data.db.DbHelper
import com.vicky7230.monumental.data.network.ApiHelper
import com.vicky7230.monumental.data.prefs.PreferencesHelper


interface DataManager : ApiHelper, DbHelper, PreferencesHelper {
}