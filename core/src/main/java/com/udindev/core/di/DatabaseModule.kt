package com.udindev.core.di

import android.content.Context
import androidx.room.Room
import com.udindev.core.data.source.local.room.NewsDao
import com.udindev.core.data.source.local.room.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideNewsDatabase(@ApplicationContext context: Context) : NewsDatabase =
        Room.databaseBuilder(
            context,
            NewsDatabase::class.java,
            "bbc_news.db"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideNewsDao(newsDatabase: NewsDatabase): NewsDao = newsDatabase.getNewsDao()

}