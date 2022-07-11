package com.example.helloworld_feature2

import com.example.helloworldcore.DataModels.PlaceholderResult
import com.example.helloworldcore.Repository

class Feature2_Repository: Repository() {
    private val remoteDataSource: RemoteDataSource = RemoteDataSource()

    suspend fun fetchComment() = remoteDataSource.fetchData()

    suspend fun placeholder(): PlaceholderResult {
        return PlaceholderResult(1, 1, "feature2", false)
    }

    suspend fun updatePlaceholder(placeholder: PlaceholderResult): PlaceholderResult {
        return PlaceholderResult(placeholder.id, placeholder.userId, placeholder.title + " updated", placeholder.completed)
    }
}