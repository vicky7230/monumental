package com.vicky7230.monumental.data.db

import com.vicky7230.monumental.data.db.entity.User

interface DbHelper {
    suspend fun insertUser(user: User): Long
}
