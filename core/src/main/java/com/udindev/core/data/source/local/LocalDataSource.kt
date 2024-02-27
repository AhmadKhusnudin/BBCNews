package com.udindev.core.data.source.local

import com.udindev.core.data.source.local.entity.NewsEntity
import com.udindev.core.data.source.local.room.NewsDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val newsDao: NewsDao
) {
    fun getAllNews() = newsDao.getAllNews()

    fun getFavoriteNews() = newsDao.getFavoriteNews()

    suspend fun insertNews(newsList: List<NewsEntity>) = newsDao.insertNews(newsList)

    suspend fun setFavoriteNews(title: String, isFavorite: Boolean)  = newsDao.updateFavoriteNews(title, isFavorite)
}