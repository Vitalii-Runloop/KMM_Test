package com.example.helloworld_kmm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.helloworld.DataModels.PlaceholderResult
import com.example.helloworld.Repository
import kotlinx.coroutines.flow.StateFlow

class ListViewModel : ViewModel() {
    private val repository = Repository()

    val placeholders: StateFlow<List<PlaceholderResult>> =
        repository.placeholders

//    private val mutablePlaceholders = MutableLiveData<List<PlaceholderResult>>()
//    val placeholders: LiveData<List<PlaceholderResult>> get() = mutablePlaceholders

    init {
        val list = listOf(1..50).flatten().map { PlaceholderResult(it.toLong(), 0, "test", false) }

//        mutablePlaceholders.value = repository.placeholders.value
    }
}