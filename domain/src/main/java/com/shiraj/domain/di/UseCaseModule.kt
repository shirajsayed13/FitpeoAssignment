package com.shiraj.domain.di

import com.shiraj.domain.usecase.PhotosUseCase
import com.shiraj.domain.usecase.PhotosUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    internal abstract fun bindPhotosUseCase(useCaseImpl: PhotosUseCaseImpl): PhotosUseCase
}