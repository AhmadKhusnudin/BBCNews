package com.udindev.core.domain.usecase

import com.udindev.core.domain.model.News
import kotlinx.coroutines.flow.Flow

interface FavoriteUseCase {
    fun getFavoriteNews(): Flow<List<News>>
    suspend fun setFavoriteNews(title: String, isFavorite: Boolean)
}