package com.udindev.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udindev.core.domain.usecase.FavoriteUseCase
import com.udindev.core.domain.usecase.NewsUseCase
import javax.inject.Inject

class FavoriteViewModelFactory @Inject constructor(
    private val favoriteUseCase: FavoriteUseCase
): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> FavoriteViewModel(favoriteUseCase) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class ${modelClass.name}")
        }
}