package com.elhady.ijobs.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by islam elhady on 22-Mar-21.
 */
@Parcelize
class Jobs(
    val id: String,
    val type: String,
    val url: String,
    val created_at: String,
    val company: String,
    val company_url: String,
    val location: String,
    val title: String,
    val description: String,
    val company_logo: String
) : Parcelable