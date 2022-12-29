package com.shiraj.fitpeoassignment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.shiraj.fitpeoassignment.base.BaseFragment
import com.shiraj.fitpeoassignment.databinding.FragmentDetailBinding
import com.shiraj.fitpeoassignment.setImageUrl

class DetailFragment : BaseFragment() {

    private lateinit var binding: FragmentDetailBinding

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return if (::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentDetailBinding.inflate(inflater, container, false)
            with(binding) {
                root
            }
        }
    }

    override fun subscribeUI() {
        val photo = args.photo
        binding.apply {
            tvTitle.text = photo.title
            setImageUrl(ivPhotos, photo.url)
        }
    }

}