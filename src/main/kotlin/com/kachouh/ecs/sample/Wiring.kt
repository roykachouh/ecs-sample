package com.kachouh.ecs.sample

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.ecs.AmazonECSClientBuilder
import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.support.beans
import org.springframework.web.client.RestTemplate

fun beans() = beans {
    bean<RestTemplate> { RestTemplateBuilder().build() }
    bean {
        val accessKey = "fail"
        val secretKey = "fail"

        val clientBuilder = AmazonECSClientBuilder.standard()

        clientBuilder.credentials = AWSStaticCredentialsProvider(BasicAWSCredentials(accessKey, secretKey))
        clientBuilder.region = "us-west-2"

        clientBuilder.build()
    }

    bean {
        val registration = FilterRegistrationBean<AWSXRayServletFilter>()
        registration.filter = AWSXRayServletFilter()
        registration.addUrlPatterns("*")
        registration.setName("XRayServletFilter")
        registration.addInitParameter("fixedName", "roy-sample-service")
        registration.order = 1
        registration
    }
}