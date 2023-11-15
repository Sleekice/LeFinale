package com.example.data.model.remote.bbcnews


import com.google.gson.annotations.SerializedName

data class BBCNewsDataModel(
    @SerializedName("articles")
    val articles: List<ArticleModel?>? = listOf(),
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("totalResults")
    val totalResults: Int? = 0
)