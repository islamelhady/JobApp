package com.elhady.ijobs.data.model

import com.squareup.moshi.Json

data class JobsResponse (
    @Json(name ="job-count")
    var jobCount: Int? = null,
    var jobs: List<Job>? = null,
    var legalNotice: String? = null
)