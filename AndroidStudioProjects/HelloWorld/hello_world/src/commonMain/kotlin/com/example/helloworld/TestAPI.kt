package com.example.helloworld

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class TestAPI {
    @Serializable
    class PlaceholderResult(val id: Int, val userId: Int, val title: String, val completed: Boolean)

    private val client: HttpClient = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    private var baseUrl: String = "https://jsonplaceholder.typicode.com"

    init {}

    suspend fun fetchPlaceholder() = client.get("$baseUrl/todos/1").body<PlaceholderResult>()
}