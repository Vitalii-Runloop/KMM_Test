package com.example.helloworldcore.Data

import com.example.helloworldcore.HWDatabase
import com.squareup.sqldelight.db.SqlDriver

internal expect object Db {
    fun dbSetup(driver: SqlDriver)

    fun dbClear()

    val instance: HWDatabase
}