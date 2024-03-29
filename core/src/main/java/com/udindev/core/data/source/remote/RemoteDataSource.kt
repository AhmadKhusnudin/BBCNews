package com.udindev.core.data.source.remote

import com.udindev.core.data.source.remote.retrofit.ApiResponse
import com.udindev.core.data.source.remote.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getListNews() = flow {
        try {

            val response = apiService.getNews("db874e166f4c473e9132d19a45135274").articles

            if (response.isNotEmpty()) emit(ApiResponse.Success(response)) else ApiResponse.Empty

        } catch (e: Exception) {
            emit(ApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}