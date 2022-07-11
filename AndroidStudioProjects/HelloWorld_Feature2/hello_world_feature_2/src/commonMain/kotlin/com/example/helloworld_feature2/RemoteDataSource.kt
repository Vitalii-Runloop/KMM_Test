package com.example.helloworld_feature2

internal class RemoteDataSource(
    private val api: Feature2_API = Feature2_API(),
) {
    suspend fun fetchData() = api.fetchComment()
}