package com.udindev.core.domain.usecase

import com.udindev.core.domain.repository.NewsRepository
import javax.inject.Inject

class NewsUseCaseImpl @Inject constructor(
    private val newsRepository: NewsRepository
) : NewsUseCase {
    override fun getAllNews() = newsRepository.getAllNews()

}