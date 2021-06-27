package com.elhady.ijobs.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by islam elhady on 22-Mar-21.
 */
@Entity
@Parcelize
class Jobs(
    @PrimaryKey val id: String,
    val type: String,
    val url: String,
    val created_at: String,
    val company: String,
    val company_url: String,
    val location: String,
    val title: String,
    val description: String,
    val how_to_apply: String,
    val company_logo: String,
    val is_mark: Int
) : Parcelable

data class JobsResponse (val jobs: List<Jobs>)