package com.udindev.bbcnews.di

import com.udindev.core.domain.usecase.FavoriteUseCase
import com.udindev.core.domain.usecase.FavoriteUseCaseImpl
import com.udindev.core.domain.usecase.NewsUseCase
import com.udindev.core.domain.usecase.NewsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideNewsUseCase(newsUseCaseImpl: NewsUseCaseImpl) : NewsUseCase

    @Binds
    @Singleton
    abstract fun provideFavoriteUseCase(favoriteUseCaseImpl: FavoriteUseCaseImpl): FavoriteUseCase
}