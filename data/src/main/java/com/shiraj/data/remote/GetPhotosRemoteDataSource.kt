package com.shiraj.data.remote

import com.shiraj.data.BaseRemoteDataSource
import com.shiraj.data.service.ApiService
import com.shiraj.domain.model.Output
import com.shiraj.domain.model.PhotosResponse
import retrofit2.Retrofit
import javax.inject.Inject

class GetPhotosRemoteDataSource @Inject constructor(
    private val apiService: ApiService,
    retrofit: Retrofit
) : BaseRemoteDataSource(retrofit) {

    suspend fun fetchPhotos(): Output<List<PhotosResponse>> {
        return getResponse(
            request = { apiService.fetchPhotos() },
            defaultErrorMessage = "Error fetching Photos"
        )
    }
}