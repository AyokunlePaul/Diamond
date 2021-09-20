package com.diamond.data.model

data class BasePagedModel<T>(
    val data: T,
    val page: Int,
    val totalPages: Int
)
