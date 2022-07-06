package com.example.helloworld

import com.example.helloworld.Data.Db
import com.example.helloworld.DataModels.PlaceholderResult
import com.example.helloworld.DataModels.PlaceholderResultDb
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.*

internal class LocalDataSource {
    private val database: HWDatabase get() = Db.instance

    val placeholders: StateFlow<List<PlaceholderResult>> get() = database.placeholderResultQueries
        .selectAll { id, userId, title, completed
            ->
            PlaceholderResult(id, userId, title, completed)
        }.asFlow().mapToList().stateIn(MainScope(), SharingStarted.Lazily, emptyList())

    fun insertPlaceholder(placeholder: PlaceholderResult) {
        database.placeholderResultQueries.insertResult(placeholder.let { PlaceholderResultDb(it.id, it.userId, it.title, it.completed) })
    }

    fun getAllPlaceholders(): List<PlaceholderResult> {
        return placeholders.value
    }

    fun removePlaceholder(id: Long) {
        database.placeholderResultQueries.delete(id)
    }

    fun removeAllPlaceholders() {
        database.placeholderResultQueries.deleteAll()
    }
}