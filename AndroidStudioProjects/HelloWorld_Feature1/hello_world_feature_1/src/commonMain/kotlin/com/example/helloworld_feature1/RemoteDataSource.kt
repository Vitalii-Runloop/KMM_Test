package com.example.helloworld_feature1

internal class RemoteDataSource(
    private val api: Feature1_API = Feature1_API(),
) {
    suspend fun fetchData() = api.fetchPost()
}