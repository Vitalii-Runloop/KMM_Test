package com.example.helloworld

import com.example.helloworld.DataModels.PlaceholderResult
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.StateFlow

class Repository() {
    private val remoteDataSource: RemoteDataSource = RemoteDataSource()
    internal val localDataSource: LocalDataSource = LocalDataSource()

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.Default

    val placeholder: StateFlow<PlaceholderResult?> get() =
        remoteDataSource.placeholder
    val placeholders: StateFlow<List<PlaceholderResult>> get() =
        localDataSource.placeholders

    init {
        CoroutineScope(ioDispatcher).launch {
            placeholder.collect {
                it?.let {
                    localDataSource.insertPlaceholder(it)
                }
            }
        }
    }

    fun startMonitoring() {
        remoteDataSource.startUpdating()
    }

    fun stopMonitoring() {
        remoteDataSource.stopUpdating()
    }

}