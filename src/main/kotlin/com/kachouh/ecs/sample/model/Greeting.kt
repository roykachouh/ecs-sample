package com.kachouh.ecs.sample.model

import com.amazonaws.services.ecs.model.ListClustersResult

data class Greeting(
        val name: String,
        val hostname: String,
        val clusters: ListClustersResult
)