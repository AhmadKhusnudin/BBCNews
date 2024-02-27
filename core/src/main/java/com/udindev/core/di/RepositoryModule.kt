package com.udindev.core.di

import com.udindev.core.data.repository.NewsRepositoryImpl
import com.udindev.core.domain.repository.NewsRepository
import com.udindev.core.domain.usecase.FavoriteUseCase
import com.udindev.core.domain.usecase.FavoriteUseCaseImpl
import com.udindev.core.domain.usecase.NewsUseCase
import com.udindev.core.domain.usecase.NewsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideNewsRepository(newsRepositoryImpl: NewsRepositoryImpl) : NewsRepository

}