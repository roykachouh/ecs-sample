package com.kachouh.ecs.sample.model

data class Metadata(
        val cluster: String,
        val containerInstanceArn: String,
        val version: String
)