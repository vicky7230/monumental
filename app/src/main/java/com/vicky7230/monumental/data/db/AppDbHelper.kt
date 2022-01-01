package com.vicky7230.monumental.data.db

import com.vicky7230.monumental.data.db.entity.User


class AppDbHelper(private val appDatabase: AppDatabase) : DbHelper {

    override suspend fun insertUser(user: User): Long {
        return appDatabase.userDao().insertTask(user)
    }
}