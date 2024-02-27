package com.udindev.bbcnews.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udindev.core.domain.usecase.FavoriteUseCase
import com.udindev.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailNewsViewModel @Inject constructor(
    private val favoriteUseCase: FavoriteUseCase
) : ViewModel() {
    fun setFavoriteNews(title: String, isFavorite: Boolean) = viewModelScope.launch {
        favoriteUseCase.setFavoriteNews(title, isFavorite)
    }
}