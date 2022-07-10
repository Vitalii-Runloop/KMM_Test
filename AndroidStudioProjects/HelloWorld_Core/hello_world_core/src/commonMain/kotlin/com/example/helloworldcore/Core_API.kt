package com.example.helloworldcore

import com.example.helloworldcore.DataModels.PlaceholderResult
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlin.random.Random

class Core_API: API() {
    private var baseUrl: String = "https://jsonplaceholder.typicode.com"

    suspend fun fetchPlaceholder() = get<PlaceholderResult>("$baseUrl/todos/" + Random.nextInt(1, 100).toString())
}