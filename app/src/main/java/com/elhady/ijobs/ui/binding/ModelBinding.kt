package com.elhady.ijobs.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.elhady.ijobs.R

/**
 * Created by islam elhady on 23-Mar-21.
 */
@BindingAdapter("jobSrc")
fun bindJobSrc(view: ImageView, companyLogo: String?) {
    if(!companyLogo.isNullOrEmpty())
        Glide.with(view.context)
            .load(companyLogo)
        .apply(
            RequestOptions()
            .placeholder(R.drawable.ic_business_center)
            .error(R.drawable.ic_work))
            .into(view)
}