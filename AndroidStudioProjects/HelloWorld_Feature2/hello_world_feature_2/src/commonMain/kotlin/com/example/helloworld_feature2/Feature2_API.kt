package com.example.helloworld_feature2

import com.example.helloworldcore.API
import kotlin.random.Random

class Feature2_API: API() {
    private val baseUrl: String = "https://jsonplaceholder.typicode.com"

    suspend fun fetchComment() = getString("$baseUrl/comments/" + Random.nextInt(1, 100).toString())
}