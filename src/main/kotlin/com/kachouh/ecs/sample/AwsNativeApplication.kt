package com.kachouh.ecs.sample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class AwsNativeApplication

fun main(args: Array<String>) {
    SpringApplication.run(AwsNativeApplication::class.java, *args)
}
