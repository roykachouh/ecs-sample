package com.kachouh.ecs.sample

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication.run
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.lang.Thread.sleep
import java.util.*
import kotlin.concurrent.thread

@SpringBootApplication
class AwsNativeApplication


val LOG = LoggerFactory.getLogger(AwsNativeApplication::class.java.name)

fun main(args: Array<String>) {
    run(AwsNativeApplication::class.java, *args)


    thread(start = true) {
        while(true) {
            LOG.info("helloooooo: " + UUID.randomUUID().toString())
            sleep((Random().nextInt(1000 - 500 + 1) + 500).toLong())
        }
    }
}

