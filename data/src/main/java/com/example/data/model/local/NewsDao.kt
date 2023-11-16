package com.example.data.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {
    @Query("SELECT * FROM news")
    suspend fun getAllNews(): List<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNews(people: List<NewsEntity>)

    @Query("SELECT * FROM news WHERE id = :newsId")
    suspend fun getNewsById(newsId: Int): NewsEntity

    @Query("DELETE FROM news")
    suspend fun deleteAll()
}