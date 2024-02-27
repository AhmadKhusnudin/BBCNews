package com.udindev.core.utils

import com.udindev.core.data.source.local.entity.NewsEntity
import com.udindev.core.data.source.remote.response.ArticlesItem
import com.udindev.core.domain.model.News

object DataMapper {
    fun mapResponsesToEntities(input: List<ArticlesItem>): List<NewsEntity> {
        val newsList = ArrayList<NewsEntity>()
        input.map {
            val news = NewsEntity(
                title = it.title,
                description = it.description,
                author = it.author,
                publishedAt = it.publishedAt,
                urlToImage = it.urlToImage,
                isFavorite = false
            )
            newsList.add(news)
        }
        return newsList
    }

    fun mapEntitiesToDomain(input: List<NewsEntity>): List<News> =
        input.map {
            News(
                title = it.title,
                description = it.description.toString(),
                author = it.author.toString(),
                published = it.publishedAt,
                image = it.urlToImage.toString(),
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: News) =
        NewsEntity(
            title = input.title,
            description = input.description,
            author = input.author,
            publishedAt = input.published,
            urlToImage = input.image,
            isFavorite = input.isFavorite
        )
}