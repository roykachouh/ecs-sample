package com.kachouh.ecs.sample.model

data class Greeting(
        val name: String,
        val hostname: String,
        val metadata: Metadata?,
        val runtime: Runtime?
)