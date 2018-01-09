package com.kachouh.ecs.sample.model

data class Runtime(
        val processors: Int,
        val freeMemory: Long,
        val maxMemory: Long,
        val totalMemory: Long,
        val uname: String
)