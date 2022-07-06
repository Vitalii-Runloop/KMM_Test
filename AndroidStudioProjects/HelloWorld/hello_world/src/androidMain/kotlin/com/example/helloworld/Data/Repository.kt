package com.example.helloworld.Data

import android.content.Context
import com.example.helloworld.Repository

fun Repository.setContext(context: Context) {
    localDataSource.setContext(context)
}