package com.example.helloworld.Data

import com.example.helloworld.HWDatabase
import com.squareup.sqldelight.db.SqlDriver

internal expect object Db {
    fun dbSetup(driver: SqlDriver)

    fun dbClear()

    val instance: HWDatabase
}