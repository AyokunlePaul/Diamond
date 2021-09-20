package com.diamond.remote.model

import com.google.gson.annotations.SerializedName

data class BasePagedModel<T>(
    @SerializedName("results", alternate = ["images"]) val data: T?,
    val page: Int?,
    val total_results: Int?,
    val total_pages: Int?
)
