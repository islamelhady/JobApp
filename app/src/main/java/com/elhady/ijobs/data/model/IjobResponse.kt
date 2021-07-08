package com.elhady.ijobs.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by islam elhady on 22-Mar-21.
 */

data class RemoteJob(
    @Json(name ="job-count")
    val jobCount: Int? = null,
    val jobs: List<Job>? = null,
    val legalNotice: String? = null
)

@Parcelize
data class Job(
    val candidate_required_location: String?= null,
    val category: String?= null,
    val company_logo_url: String?= null,
    val company_name: String?= null,
    val description: String?= null,
    val id: Int?= null,
    val job_type: String?= null,
    val publication_date: String?= null,
    val salary: String?= null,
    val title: String?= null,
    val url: String?= null
): Parcelable