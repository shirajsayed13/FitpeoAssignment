package com.shiraj.domain.repository

import com.shiraj.domain.model.Output
import com.shiraj.domain.model.PhotosResponse
import kotlinx.coroutines.flow.Flow

/**
 * Interface of Photos Repository to expose to other module
 */
interface PhotosRepository {

    suspend fun fetchPhotos(): Flow<Output<List<PhotosResponse>>?>
}