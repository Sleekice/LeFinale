package com.example.data.model.remote.businessinsider


import com.google.gson.annotations.SerializedName

data class SourceModel(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("name")
    val name: String? = ""
)