package com.elhady.ijobs.ui.binding

import android.text.method.LinkMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
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

@BindingAdapter("descriptionHtml")
fun bindDescriptionHtml(view: TextView, description: String?) {
    if (description != null) {
        view.text = HtmlCompat.fromHtml(description, FROM_HTML_MODE_COMPACT)
        view.movementMethod = LinkMovementMethod.getInstance()
    } else {
        view.text = ""
    }
}

//@BindingAdapter("query")
//fun setQuery(searchView: SearchView, queryText: String) {
////        searchView.setQuery(queryText, false)
//
//}
//
//@BindingAdapter("queryTextListener")
//fun setOnQueryTextListener(searchView: SearchView, listener: SearchView.OnQueryTextListener, queryText: String) {
//    searchView.isSubmitButtonEnabled
//    searchView.setQuery(queryText, false)
//    searchView.setOnQueryTextListener(listener)
//}