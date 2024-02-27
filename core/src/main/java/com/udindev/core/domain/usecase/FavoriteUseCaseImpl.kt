package com.udindev.core.domain.usecase

import com.udindev.core.domain.repository.NewsRepository
import javax.inject.Inject

class FavoriteUseCaseImpl @Inject constructor(
    private val newsRepository: NewsRepository
) : FavoriteUseCase {
    override fun getFavoriteNews() = newsRepository.getFavoriteNews()

    override suspend fun setFavoriteNews(title: String, isFavorite: Boolean) = newsRepository.setFavoriteNews(title, isFavorite)
}