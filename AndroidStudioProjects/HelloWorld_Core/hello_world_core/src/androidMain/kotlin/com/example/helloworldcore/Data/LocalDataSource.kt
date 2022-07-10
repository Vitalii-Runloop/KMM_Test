package com.example.helloworldcore.Data

import android.content.Context
import com.example.helloworldcore.LocalDataSource
import com.example.helloworldcore.HWDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver

internal fun LocalDataSource.setContext(context: Context) {
    Db.dbSetup(AndroidSqliteDriver(HWDatabase.Schema, context, "main.db"))
}