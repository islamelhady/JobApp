package com.elhady.ijobs.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elhady.ijobs.data.model.Job

/**
 * Created by islam elhady on 11-Jul-21.
 */
@Entity
data class JobEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
//    val jobId: Int? = null,
    val candidate_required_location: String?,
    val category: String?,
    val company_logo: String?,
    val company_logo_url: String?,
    val company_name: String?,
    val description: String?,
    val job_type: String?,
    val publication_date: String?,
    val salary: String?,
    val title: String?,
    val url: String?
)

fun Job.toFavouriteJobsEntity() = JobEntity(
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