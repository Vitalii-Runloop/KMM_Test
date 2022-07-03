package com.example.helloworld.DataModels

import kotlinx.serialization.Serializable

@Serializable
class PlaceholderResult(val id: Int, val userId: Int, val title: String, val completed: Boolean)