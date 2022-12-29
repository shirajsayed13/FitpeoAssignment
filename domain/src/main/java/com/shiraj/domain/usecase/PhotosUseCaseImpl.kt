package com.shiraj.domain.usecase

import com.shiraj.domain.model.Output
import com.shiraj.domain.repository.PhotosRepository
import com.shiraj.domain.model.PhotosResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Implementation of Photos UseCase
 */
internal class PhotosUseCaseImpl @Inject constructor(
    private val photosRepository: PhotosRepository
) : PhotosUseCase {

    override suspend fun execute(): Flow<Output<List<PhotosResponse>>?> {
        return photosRepository.fetchPhotos()
    }

}