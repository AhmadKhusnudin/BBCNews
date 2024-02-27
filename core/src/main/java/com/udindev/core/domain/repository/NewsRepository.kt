package com.udindev.core.domain.repository

import com.udindev.core.data.Resource
import com.udindev.core.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getAllNews(): Flow<Resource<List<News>>>

    fun getFavoriteNews(): Flow<List<News>>

    suspend fun setFavoriteNews(title: String, isFavorite: Boolean)
}