package com.kachouh.ecs.sample.web

import com.kachouh.ecs.sample.ecs.FetchClusters
import com.kachouh.ecs.sample.model.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.InetAddress

@RestController
class HelloEcsController(val fetchClusters: FetchClusters) {

    @GetMapping("/hello-ecs")
    fun helloEcs(@RequestParam(value = "name", defaultValue = "Roy") name: String): Greeting {
        return Greeting(name, getHost(), fetchClusters.fetch())
    }

    companion object {
        fun getHost(): String = InetAddress.getLocalHost().hostAddress
    }
}


