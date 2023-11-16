package com.example.data.model.local


import androidx.room.TypeConverter
import com.example.data.model.remote.africanews.SourceModel
import com.google.gson.Gson

class SourceModelConverter {

    @TypeConverter
    fun fromSourceModel(source: SourceModel?): String? {
        return Gson().toJson(source)
    }

    @TypeConverter
    fun toSourceModel(sourceString: String?): SourceModel? {
        return Gson().fromJson(sourceString, SourceModel::class.java)
    }
}