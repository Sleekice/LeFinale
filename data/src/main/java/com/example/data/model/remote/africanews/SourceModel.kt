package com.example.data.model.remote.africanews


import com.google.gson.annotations.SerializedName

data class SourceModel(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("name")
    val name: String? = ""
)