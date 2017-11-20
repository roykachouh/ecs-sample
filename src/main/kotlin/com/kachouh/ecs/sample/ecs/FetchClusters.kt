package com.kachouh.ecs.sample.ecs

import com.amazonaws.services.ecs.AmazonECS
import org.springframework.stereotype.Component

@Component
class FetchClusters(val ecs: AmazonECS) {
    fun fetch() = ecs.listClusters()
}
