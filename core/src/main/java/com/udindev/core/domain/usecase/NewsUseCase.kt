package com.udindev.core.domain.usecase

import com.udindev.core.data.Resource
import com.udindev.core.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    fun getAllNews(): Flow<Resource<List<News>>>
}