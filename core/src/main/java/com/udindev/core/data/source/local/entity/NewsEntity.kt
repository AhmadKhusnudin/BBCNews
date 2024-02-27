package com.udindev.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "news")
class NewsEntity(
    @ColumnInfo(name = "title")
    @PrimaryKey
    var title: String,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "publishedAt")
    var publishedAt: String,

    @ColumnInfo(name = "urlToImage")
    var urlToImage: String? = null,

    @ColumnInfo(name = "author")
    var author: String? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false

) : Parcelable