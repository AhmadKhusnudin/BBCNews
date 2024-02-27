package com.udindev.bbcnews.di

import com.udindev.core.domain.usecase.FavoriteUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {
    fun provideFavoriteNewsUseCase(): FavoriteUseCase
}