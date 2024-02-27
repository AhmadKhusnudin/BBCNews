package com.udindev.core.data.source.remote.retrofit

import com.udindev.core.data.source.remote.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines?country=us")
    suspend fun getNews(@Query("apiKey") apiKey: String): NewsResponse
}