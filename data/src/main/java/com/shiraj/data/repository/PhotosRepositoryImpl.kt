package com.shiraj.data.repository

import com.shiraj.data.remote.GetPhotosRemoteDataSource
import com.shiraj.domain.model.Output
import com.shiraj.domain.model.PhotosResponse
import com.shiraj.domain.repository.PhotosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Implementation of PhotosRepository
 * @param photosRemoteDataSource the object of remote data source
 */
internal class PhotosRepositoryImpl @Inject constructor(
    private val photosRemoteDataSource: GetPhotosRemoteDataSource
): PhotosRepository {

    override suspend fun fetchPhotos(): Flow<Output<List<PhotosResponse>>?> {
        return flow {
            emit(Output.loading())
            val result = photosRemoteDataSource.fetchPhotos()
            emit(result.data?.let { Output.success(it) })
        }.flowOn(Dispatchers.IO)
    }
}