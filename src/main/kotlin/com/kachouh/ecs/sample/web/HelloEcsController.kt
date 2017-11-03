package com.kachouh.ecs.sample.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloEcsController {

    @GetMapping("/hello-ecs")
    fun helloEcs(@RequestParam(value = "name", defaultValue = "Roy") name: String) = "Hello, $name"
}


