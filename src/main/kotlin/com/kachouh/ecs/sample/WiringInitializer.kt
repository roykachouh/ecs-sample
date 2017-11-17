package com.kachouh.ecs.sample

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext

class WiringInitializer : ApplicationContextInitializer<GenericApplicationContext> {

    override fun initialize(context: GenericApplicationContext) = beans().initialize(context)
}