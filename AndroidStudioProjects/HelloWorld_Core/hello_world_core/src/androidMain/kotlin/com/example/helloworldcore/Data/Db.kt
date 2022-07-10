package com.example.helloworldcore.Data

import com.example.helloworldcore.HWDatabase
import com.squareup.sqldelight.db.SqlDriver

internal actual object Db {
    private var driverRef: SqlDriver? = null
    private var dbRef: HWDatabase? = null

    val ready: Boolean
        get() = driverRef != null

    actual fun dbSetup(driver: SqlDriver) {
        dbClear()

        val db = HWDatabase(driver)
        driverRef = driver
        dbRef = db
    }

    actual fun dbClear() {
        driverRef?.close()
        dbRef = null
        driverRef = null
    }

    actual val instance: HWDatabase
        get() = dbRef!!
}