package com.udindev.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.udindev.core.domain.usecase.FavoriteUseCase
import com.udindev.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    favoriteUseCase: FavoriteUseCase
): ViewModel() {
    val favoriteNews = favoriteUseCase.getFavoriteNews().asLiveData()
}