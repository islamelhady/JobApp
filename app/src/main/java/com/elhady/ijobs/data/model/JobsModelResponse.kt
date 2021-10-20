package com.elhady.ijobs.data.model

import android.os.Parcelable
import com.elhady.ijobs.data.local.JobEntity
import kotlinx.android.parcel.Parcelize

/**
 * Created by islam elhady on 22-Mar-21.
 */
@Parcelize
data class Job(
    val candidate_required_location: String?,
    val category: String?,
    val company_logo: String?,
    val company_logo_url: String?,
    val company_name: String?,
    val description: String?,
    val id: Int?,
    val job_type: String?,
    val publication_date: String?,
    val salary: String?,
    val title: String?,
    val url: String?
) : Parcelable

fun JobEntity.toJobViewResponse() = Job(
    id = id,
    salary = salary,
    title = title,
    url = url,
    category = category,
    company_logo = company_logo,
    company_logo_url = company_logo_url,
    company_name = company_name,
    description = description,
    job_type = job_type,
    publication_date = publication_date,
    candidate_required_location = candidate_required_location
)