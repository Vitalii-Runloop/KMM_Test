package com.example.helloworld_feature1

import com.example.helloworldcore.API
import kotlin.random.Random

class Feature1_API: API() {
    private val baseUrl: String = "https://jsonplaceholder.typicode.com"

    suspend fun fetchPost() = getString("$baseUrl/posts/" + Random.nextInt(1, 100).toString())
}