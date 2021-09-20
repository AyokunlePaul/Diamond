package com.diamond.domain.thread

import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class DiamondExecutionThread @Inject constructor() : ExecutionThread {
    override val io: CoroutineContext get() = Dispatchers.IO
    override val main: CoroutineContext get() = Dispatchers.Main
}