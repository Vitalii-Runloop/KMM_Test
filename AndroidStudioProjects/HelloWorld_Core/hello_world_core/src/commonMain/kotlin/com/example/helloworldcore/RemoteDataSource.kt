package com.example.helloworldcore

import com.example.helloworldcore.DataModels.PlaceholderResult
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

internal class RemoteDataSource(
    private val api: Core_API = Core_API(),
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
//    var placeholder: Flow<PlaceholderResult> = flow {
//        while(true) {
//            val placeholder = fetchData()
//            emit(placeholder) // Emits the result of the request to the flow
//            delay(5000) // Suspends the coroutine for some time
//        }
//    }

    private var updating: Boolean = false
    private val _placeholder = MutableStateFlow<PlaceholderResult?>(null)
    val placeholder = _placeholder.asStateFlow()

    fun startUpdating() {
        updating = true
        CoroutineScope(ioDispatcher).launch {
            while(updating) {
                _placeholder.value = fetchData()
                delay(1000) // Suspends the coroutine for some time
            }
        }
    }

    fun stopUpdating() {
        updating = false
    }

    /**
     * Fetches the latest news from the network and returns the result.
     * This executes on an IO-optimized thread pool, the function is main-safe.
     */
    suspend fun fetchData(): PlaceholderResult =
    // Move the execution to an IO-optimized thread since the ApiService
        // doesn't support coroutines and makes synchronous requests.
        withContext(ioDispatcher) {
            api.fetchPlaceholder()
        }
}