package com.example.helloworldcore.DataModels

import kotlinx.serialization.Serializable

@Serializable
class PlaceholderResult(val id: Long, val userId: Long, val title: String, val completed: Boolean)