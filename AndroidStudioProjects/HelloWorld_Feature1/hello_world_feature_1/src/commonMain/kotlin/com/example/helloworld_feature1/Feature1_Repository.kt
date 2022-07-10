package com.example.helloworld_feature1

import com.example.helloworldcore.DataModels.PlaceholderResult
import com.example.helloworldcore.Repository

class Feature1_Repository: Repository() {
//    val something: String = "BLYAAAAAA"
//    private val remoteDataSource_f1: RemoteDataSource = RemoteDataSource()

    suspend fun fetchPost() = Feature1_API().fetchPost()

    suspend fun placeholder(): PlaceholderResult {
        return PlaceholderResult(0, 0, "feature1", false)
    }

    suspend fun updatePlaceholder(placeholder: PlaceholderResult): PlaceholderResult {
        return PlaceholderResult(placeholder.id, placeholder.userId, placeholder.title + " updated", placeholder.completed)
    }
}