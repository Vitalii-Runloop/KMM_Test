package com.example.helloworld

import com.example.helloworld.DataModels.PlaceholderResult
import kotlinx.coroutines.flow.StateFlow

class Repository() {
    private val remoteDataSource: RemoteDataSource = RemoteDataSource()

    val placeholder: StateFlow<PlaceholderResult?> =
        remoteDataSource.placeholder

    fun startMonitoring() {
        remoteDataSource.startUpdating()
    }

    fun stopMonitoring() {
        remoteDataSource.stopUpdating()
    }

}