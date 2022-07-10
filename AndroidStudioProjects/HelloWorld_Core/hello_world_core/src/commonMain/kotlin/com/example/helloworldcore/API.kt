package com.example.helloworldcore

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

open class API {
    @PublishedApi
    internal val client: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend inline fun <reified T> get(url: String): T = client.get(url).body()
    suspend inline fun getString(url: String): String = client.get(url).bodyAsText()

}