package com.example.data.model.remote.donaldtrumpnews


import com.google.gson.annotations.SerializedName

data class SourceModel(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("name")
    val name: String? = ""
)