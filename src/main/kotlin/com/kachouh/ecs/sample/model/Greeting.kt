package com.kachouh.ecs.sample.model

import com.github.dockerjava.api.model.Container

data class Greeting(val name: String, val containers: List<Container>)