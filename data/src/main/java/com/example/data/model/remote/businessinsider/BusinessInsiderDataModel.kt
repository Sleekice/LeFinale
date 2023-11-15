package com.example.data.model.remote.businessinsider


import com.google.gson.annotations.SerializedName

data class BusinessInsiderDataModel(
    @SerializedName("articles")
    val articles: List<ArticleModel?>? = listOf(),
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("totalResults")
    val totalResults: Int? = 0
)