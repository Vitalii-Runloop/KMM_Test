package com.example.helloworldcore.Data

import android.content.Context
import com.example.helloworldcore.Repository

fun Repository.setContext(context: Context) {
    localDataSource.setContext(context)
}