package com.kachouh.ecs.sample.web

import com.github.dockerjava.api.DockerClient
import com.kachouh.ecs.sample.model.Greeting
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloEcsController {
    @Autowired
    lateinit var dockerClient: DockerClient

    @GetMapping("/hello-ecs")
    fun helloEcs(@RequestParam(value = "name", defaultValue = "Roy") name: String): Greeting {
        val containers = dockerClient.listContainersCmd().exec()
        return Greeting(name, containers)
    }
}


