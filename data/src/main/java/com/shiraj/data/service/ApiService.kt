package com.shiraj.data.service

import com.shiraj.domain.model.PhotosResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Retrofit API Service
 */
interface ApiService {

    //https://jsonplaceholder.typicode.com/albums/3/photos
    @GET("albums/1/photos")
    suspend fun fetchPhotos(): Response<List<PhotosResponse>>
}