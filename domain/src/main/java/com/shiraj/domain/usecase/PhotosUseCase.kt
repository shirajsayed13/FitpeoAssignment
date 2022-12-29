package com.shiraj.domain.usecase

import com.shiraj.domain.model.Output
import com.shiraj.domain.model.PhotosResponse
import kotlinx.coroutines.flow.Flow

/**
 * Interface of Photos UseCase to expose to ui module
 */
interface PhotosUseCase {

    suspend fun execute(): Flow<Output<List<PhotosResponse>>?>
}