package com.example.helloworld_kmm.ui.main

import androidx.lifecycle.ViewModel
import com.example.helloworld.DataModels.PlaceholderResult
import com.example.helloworld.Repository
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val repository = Repository()

    val placeholder: StateFlow<PlaceholderResult?> =
        repository.placeholder

    init {
        startMonitoring()
    }

    fun startMonitoring() {
        repository.startMonitoring()
    }

    fun stopMonitoring() {
        repository.stopMonitoring()
    }

}