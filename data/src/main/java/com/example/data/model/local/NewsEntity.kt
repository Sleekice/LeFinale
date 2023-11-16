package com.example.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.remote.africanews.SourceModel
import com.google.gson.annotations.SerializedName


@Entity(tableName = "news")

data class NewsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    val author: String? = "",

    val content: String? = "",

    val description: String? = "",

    val publishedAt: String? = "",

    val source: SourceModel? = SourceModel(),

    val title: String? = "",

    val url: String? = "",

    val urlToImage: String? = ""
)

