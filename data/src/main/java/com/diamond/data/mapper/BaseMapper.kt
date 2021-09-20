package com.diamond.data.mapper

interface BaseMapper<FROM, TO> {
    fun mapFrom(from: FROM?): TO
    fun mapTo(to: TO?): FROM { throw IllegalArgumentException() }

    fun mapFromList(from: List<FROM>?) = from?.map { mapFrom(it) } ?: emptyList()
    fun mapToList(to: List<TO>?) = to?.map { mapTo(it) } ?: emptyList()

    val Int?.safe get() = this ?: 0
    val String?.safe get() = this ?: ""
    val Boolean?.safe get() = this ?: false
    val Double?.safe get() = this ?: 0.0
    fun <T> List<T>?.safe() = this ?: emptyList()
}