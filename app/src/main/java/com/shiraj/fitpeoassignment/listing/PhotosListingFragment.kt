package com.shiraj.fitpeoassignment.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.shiraj.domain.model.Output
import com.shiraj.fitpeoassignment.base.BaseFragment
import com.shiraj.fitpeoassignment.databinding.FragmentPhotosListingBinding

class PhotosListingFragment : BaseFragment() {

    private lateinit var binding: FragmentPhotosListingBinding

    private val viewModel: PhotosViewModel by viewModels()

    private val listingAdapter: ListingAdapter by lazy(LazyThreadSafetyMode.NONE) { ListingAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return if (::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentPhotosListingBinding.inflate(inflater, container, false)
            with(binding) {
                root
            }
        }
    }

    override fun subscribeUI() {
        viewModel.fetchPhotos()
        binding.apply {
            rvPhotos.setHasFixedSize(true)
            rvPhotos.setItemViewCacheSize(20)
            rvPhotos.adapter = listingAdapter
        }
        setUpPhotosObserver()
        listingAdapter.onPhotoClickListener = { photo ->
            val action = PhotosListingFragmentDirections
                .actionPhotosListingFragmentToDetailFragment(photo)
            findNavController().navigate(action)
        }
    }

    private fun setUpPhotosObserver() {
        viewModel.photos.observe(viewLifecycleOwner) { result ->
            when (result?.status) {
                Output.Status.SUCCESS -> {
                    result.data?.let { photos ->
                        binding.pbLoading.visibility = View.GONE
                        listingAdapter.submitList(photos)
                    }
                }

                Output.Status.ERROR -> {
                    result.message?.let {
                        showError(it) {
                            binding.tvNotFound.visibility = View.VISIBLE
                        }
                    }
                }

                Output.Status.LOADING -> {
                    binding.pbLoading.visibility = View.VISIBLE
                }
                else -> {
                    showMessage("Something went wrong")
                }
            }
        }
    }

}