package com.example.helloworldcore.Data

import com.example.helloworldcore.HWDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import kotlin.native.concurrent.AtomicReference
import kotlin.native.concurrent.freeze

internal actual object Db {
    private val driverRef = AtomicReference<SqlDriver?>(null)
    private val dbRef = AtomicReference<HWDatabase?>(null)

    init {
        dbSetup(NativeSqliteDriver(HWDatabase.Schema, "main.db"))
    }

    actual fun dbSetup(driver: SqlDriver) {
        val db = HWDatabase(driver)
        driverRef.value = driver.freeze()
        dbRef.value = db.freeze()
    }

    actual fun dbClear() {
        driverRef.value!!.close()
        dbRef.value = null
        driverRef.value = null
    }

    actual val instance: HWDatabase
        get() = dbRef.value!!
}