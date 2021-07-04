package com.elhady.ijobs.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by islam elhady on 22-Mar-21.
 */

data class AllIjobsResponse(val jobs: List<Ijob>?)

@Parcelize
class Ijob(
    val candidate_required_location: String?,
    val category: String?,
    val company_logo_url: String?,
    val company_name: String?,
    val description: String?,
    val id: Int?,
    val job_type: String?,
    val publication_date: String?,
    val salary: String,
    val tags: List<String>?,
    val title: String?,
    val url: String?
) : Parcelable