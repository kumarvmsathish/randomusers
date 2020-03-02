package com.infinite.randomusers.adapter

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.infinite.randomusers.R
import com.infinite.randomusers.utils.HTTPS

@BindingAdapter("imageUrl", requireAll = false)
fun loadImageFromUrl(imageView: ImageView, imageUrl: String?){

    imageUrl?.let {
        val imageUri = it.toUri().buildUpon().scheme(HTTPS).build()
        Glide.with(imageView.context)
            .load(imageUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
            .into(imageView)
    }

}