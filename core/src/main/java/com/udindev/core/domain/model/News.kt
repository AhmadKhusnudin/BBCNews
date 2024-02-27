package com.udindev.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val title: String,
    val description: String,
    val author: String,
    val published: String,
    val image: String,
    val isFavorite: Boolean
) : Parcelable