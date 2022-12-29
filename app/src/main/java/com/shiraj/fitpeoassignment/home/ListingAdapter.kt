package com.shiraj.fitpeoassignment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shiraj.domain.model.PhotosResponse
import com.shiraj.fitpeoassignment.databinding.ItemPhotoBinding
import com.shiraj.fitpeoassignment.setImageUrl
import javax.inject.Inject

/**
 * RecyclerView Adapter to display Listing.
 */
class ListingAdapter @Inject constructor() :
    ListAdapter<PhotosResponse, ListingAdapter.ListingViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<PhotosResponse>() {
        override fun areItemsTheSame(oldItem: PhotosResponse, newItem: PhotosResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PhotosResponse, newItem: PhotosResponse): Boolean {
            return oldItem == newItem
        }
    }

    internal var onPhotoClickListener: (PhotosResponse) -> Unit = { _ -> }

    inner class ListingViewHolder(
        private val binding: ItemPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: PhotosResponse) {
            binding.apply {
                tvTitle.text = photo.title
                setImageUrl(ivPhotos, photo.url)
            }
            itemView.setOnClickListener {
                onPhotoClickListener(photo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder {
        val binding =
            ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }
}