package com.kachouh.ecs.sample

import com.kachouh.ecs.sample.ecs.UpdateService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ECSDeployer(
        val updater: UpdateService) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (args.contains("--image")) {
            updater.update(args[1])
            System.exit(0)
        }
    }
}