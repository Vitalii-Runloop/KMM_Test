package com.example.helloworld_kmm.ui.main

import androidx.lifecycle.ViewModel
import com.example.helloworld.TestAPI

class MainViewModel : ViewModel() {

    lateinit var placeholder: TestAPI.PlaceholderResult

    suspend fun loadPlaceholder() {
        placeholder = TestAPI().fetchPlaceholder()
    }
}