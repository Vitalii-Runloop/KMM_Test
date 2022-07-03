package com.example.helloworld

import com.example.helloworld.DataModels.PlaceholderResult
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlin.random.Random

internal class API {
    private val client: HttpClient = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    private var baseUrl: String = "https://jsonplaceholder.typicode.com"

    init {}

    suspend fun fetchPlaceholder() = client.get("$baseUrl/todos/" + Random.nextInt(0, 100).toString()).body<PlaceholderResult>()
}