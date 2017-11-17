package com.kachouh.ecs.sample.web

import com.kachouh.ecs.sample.model.Greeting
import com.kachouh.ecs.sample.model.Metadata
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

const val METADATA_ENDPOINT = "http://localhost:51678/v1/metadata"

@RestController
class HelloEcsController(val restTemplate: RestTemplate) {

    @GetMapping("/hello-ecs")
    fun helloEcs(@RequestParam(value = "name", defaultValue = "ecs") name: String): Greeting {
        return Greeting(name, fetchMetadata())
    }

    fun fetchMetadata(): Metadata? {
        return try {
            restTemplate.getForObject(METADATA_ENDPOINT, Metadata::class.java)
        } catch (e: Exception) {
            null
        }
    }
}