package com.udindev.core.data.repository

import com.udindev.core.data.networkBoundResource
import com.udindev.core.data.source.local.LocalDataSource
import com.udindev.core.data.source.remote.RemoteDataSource
import com.udindev.core.domain.model.News
import com.udindev.core.domain.repository.NewsRepository
import com.udindev.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource
) : NewsRepository {
    override fun getAllNews() = networkBoundResource(
        query = {
            local.getAllNews().map {
                DataMapper.mapEntitiesToDomain(it)
            }
        },
        fetch = {
            remote.getListNews()
        },
        saveFetchResult = {
            val entity = DataMapper.mapResponsesToEntities(it)
            local.insertNews(entity)
        },
        shouldFetch = {
            it.isNullOrEmpty()
        }
    )

    override fun getFavoriteNews(): Flow<List<News>> {
        return local.getFavoriteNews().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override suspend fun setFavoriteNews(title: String, isFavorite: Boolean) {
        return local.setFavoriteNews(title, isFavorite)
    }
}