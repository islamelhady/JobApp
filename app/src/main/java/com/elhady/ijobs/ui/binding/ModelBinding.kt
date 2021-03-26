package com.elhady.ijobs.ui.binding

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.elhady.ijobs.R

/**
 * Created by islam elhady on 23-Mar-21.
 */
@BindingAdapter("jobSrc")
fun bindJobSrc(view: ImageView, companyLogo: String?) {
    if (!companyLogo.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(companyLogo)
            .error(ContextCompat.getDrawable(view.context, R.drawable.ic_business_center))
            .into(view)
    }
}