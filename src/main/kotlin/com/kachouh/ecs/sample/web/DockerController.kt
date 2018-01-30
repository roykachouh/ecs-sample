package com.kachouh.ecs.sample.web

import com.github.dockerjava.api.DockerClient
import com.github.dockerjava.api.command.ListVolumesResponse
import com.github.dockerjava.api.model.Container
import com.github.dockerjava.api.model.Image
import com.github.dockerjava.api.model.Version
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class DockerController(val dockerClient: DockerClient) {


    @GetMapping("/docker/version")
    fun version(): Version? {
        return dockerClient.versionCmd().exec()
    }

    @GetMapping("/docker/images")
    fun images(): List<Image> {
        return dockerClient.listImagesCmd().exec()
    }

    @GetMapping("/docker/volumes")
    fun volumes(): ListVolumesResponse? {
        return dockerClient.listVolumesCmd().exec()
    }

    @GetMapping("/docker/containers")
    fun containers(): List<Container> {
        return dockerClient.listContainersCmd().exec()
    }
}