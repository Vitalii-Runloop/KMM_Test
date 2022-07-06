package com.example.helloworld.Data

import android.content.Context
import com.example.helloworld.LocalDataSource
import com.example.helloworld.HWDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver

internal fun LocalDataSource.setContext(context: Context) {
    Db.dbSetup(AndroidSqliteDriver(HWDatabase.Schema, context, "main.db"))
}