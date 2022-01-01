package com.vicky7230.monumental.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "_id")//local unique identifier
    @PrimaryKey
    var id: Int,

    @ColumnInfo(name = "name")//this is the server identifier of this task
    var name: String
)