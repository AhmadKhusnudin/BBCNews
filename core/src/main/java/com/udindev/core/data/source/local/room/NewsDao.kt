package com.udindev.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udindev.core.data.source.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM news")
    fun getAllNews(): Flow<List<NewsEntity>>

    @Query("SELECT * FROM news where isFavorite = 1")
    fun getFavoriteNews(): Flow<List<NewsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(tourism: List<NewsEntity>)

    @Query("UPDATE news SET isFavorite = :isFavorite WHERE title = :title")
    suspend fun updateFavoriteNews(title: String, isFavorite: Boolean)
}