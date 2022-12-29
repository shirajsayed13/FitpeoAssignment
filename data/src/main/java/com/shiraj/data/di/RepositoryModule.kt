package com.shiraj.data.di

import com.shiraj.data.repository.PhotosRepositoryImpl
import com.shiraj.domain.repository.PhotosRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    internal abstract fun bindPhotosRepository(repositoryImpl: PhotosRepositoryImpl): PhotosRepository

}