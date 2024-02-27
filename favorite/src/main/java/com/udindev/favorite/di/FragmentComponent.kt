package com.udindev.favorite.di

import android.content.Context
import com.udindev.bbcnews.di.FavoriteModuleDependencies
import com.udindev.favorite.FavoriteFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [FavoriteModuleDependencies::class]
)
interface FavoriteComponent {
    fun inject(favoriteFragment: FavoriteFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }
}