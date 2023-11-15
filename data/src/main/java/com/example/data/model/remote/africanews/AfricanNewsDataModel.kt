package com.example.data.model.remote.africanews


import com.google.gson.annotations.SerializedName

data class AfricanNewsDataModel(
    @SerializedName("articles")
    val articles: List<ArticleModel?>? = listOf(),
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("totalResults")
    val totalResults: Int? = 0
)