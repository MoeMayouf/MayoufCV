package com.example.mayoufcv.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.mayoufcv.R
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun getCompanyLogo(imageView: ImageView, url: String?) {
    url?.let {
        Picasso.get()
            .load(url)
            .error(R.drawable.ic_cloud_off_24dp)
            .into(imageView)
        return
    }
    Picasso.get().load(R.drawable.ic_cloud_off_24dp).into(imageView)
}