package com.shiraj.fitpeoassignment

import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

fun setImageUrl(imageView: ShapeableImageView, url: String?) {
    Picasso.with(imageView.context)
        .load(randomImageUrl())
        .fit()
        .centerCrop()
        .error(R.drawable.ic_image_error)
        .into(imageView)
}

fun randomImageUrl(): String {
    val photoUrl = mutableListOf<String>()
    photoUrl.add("https://picsum.photos/id/0/5000/3333")
    photoUrl.add("https://picsum.photos/id/1/5000/3333")
    photoUrl.add("https://picsum.photos/id/2/5000/3333")
    photoUrl.add("https://picsum.photos/id/3/5000/3333")
    photoUrl.add("https://picsum.photos/id/11/2500/1667")
    photoUrl.add("https://picsum.photos/id/12/2500/1667")
    photoUrl.add("https://picsum.photos/id/13/2500/1667")
    photoUrl.add("https://picsum.photos/id/14/2500/1667")
    photoUrl.add("https://picsum.photos/id/15/2500/1667")
    val random = (0..8).random()
    return photoUrl[random]
}
