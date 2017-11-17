package com.kachouh.ecs.sample

import org.springframework.boot.SpringApplication.run
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class AwsNativeApplication

fun main(args: Array<String>) {
    run(AwsNativeApplication::class.java, *args)
}
