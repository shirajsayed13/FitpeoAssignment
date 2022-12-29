package com.shiraj.fitpeoassignment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiraj.domain.model.Output
import com.shiraj.domain.model.PhotosResponse
import com.shiraj.domain.usecase.PhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val photosUseCase: PhotosUseCase
) : ViewModel() {

    private val _photos: MutableLiveData<Output<List<PhotosResponse>>?> by lazy { MutableLiveData() }
    internal val photos: LiveData<Output<List<PhotosResponse>>?> = _photos

    internal fun fetchPhotos() {
        viewModelScope.launch {
            photosUseCase.execute().collect {
                _photos.value = it
            }
        }
    }
}