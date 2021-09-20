package com.diamond.domain.thread

import kotlin.coroutines.CoroutineContext

interface ExecutionThread {
    val io: CoroutineContext
    val main: CoroutineContext
}