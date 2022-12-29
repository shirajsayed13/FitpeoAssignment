package com.shiraj.fitpeoassignment

import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

fun setImageUrl(imageView: ShapeableImageView, url: String?) {
    val builder = Picasso.with(imageView.context)
        .load("https://via.placeholder.com/150/e743b")
        .error(R.drawable.ic_image_error)
    builder.into(imageView)
}
