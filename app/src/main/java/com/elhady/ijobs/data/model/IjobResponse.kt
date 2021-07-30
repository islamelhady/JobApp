package com.elhady.ijobs.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by islam elhady on 22-Mar-21.
 */

data class RemoteJob(
    @Json(name ="job-count")
    var jobCount: Int? = null,
    var jobs: List<Job>? = null,
    var legalNotice: String? = null
)
@Entity(tableName = "job")
@Parcelize
data class Job(
    val candidate_required_location: String?= null,
    val category: String?= null,
    val company_logo_url: String?= null,
    val company_name: String?= null,
    val description: String?= null,
    @PrimaryKey val id: Int= 0,
    val job_type: String?= null,
    val publication_date: String?= null,
    val salary: String?= null,
    val title: String?= null,
    val url: String?= null,
    var isFavorite: Boolean = false
): Parcelable