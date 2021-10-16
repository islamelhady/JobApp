package com.elhady.ijobs.ui.binding

import android.text.method.LinkMovementMethod
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.elhady.ijobs.R
import com.elhady.ijobs.utils.DAY_MONTH_YEAR_HOUR_MIN
import com.elhady.ijobs.utils.YEAR_MONTH_DAY_T_TIME
import com.elhady.ijobs.utils.toDateFormatted

/**
 * Created by islam elhady on 23-Mar-21.
 */
@BindingAdapter("jobSrc")
fun bindJobSrc(view: AppCompatImageView, companyLogo: String?) {
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
fun bindDescriptionHtml(view: AppCompatTextView, description: String?) {
    if (description != null) {
        view.text = HtmlCompat.fromHtml(description, FROM_HTML_MODE_COMPACT)
        view.movementMethod = LinkMovementMethod.getInstance()
    } else {
        view.text = ""
    }
}

@BindingAdapter("formatDate")
fun formatArticleDate(view: AppCompatTextView, date: String?) {
    view.text = date?.toDateFormatted(YEAR_MONTH_DAY_T_TIME, DAY_MONTH_YEAR_HOUR_MIN)
}


@BindingAdapter("loadUrl")
fun loadUrl(view: WebView, url: String){
    view.webViewClient = WebViewClient()
    view.loadUrl(url)
}

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}
