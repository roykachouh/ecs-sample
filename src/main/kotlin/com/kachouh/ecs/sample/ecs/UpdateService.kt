package com.kachouh.ecs.sample.ecs

import com.amazonaws.services.ecs.AmazonECS
import com.amazonaws.services.ecs.model.*
import org.springframework.stereotype.Component

const val SORT_DIR = "DESC"
const val TASK_FILTER = "ecs-sample-task"
const val CLUSTER = "ecs-sample-cluster" // TODO parameterize
const val SERVICE = "ecs-sample-service"

@Component
class UpdateService(val ecs: AmazonECS) {

    fun update(image: String?): String {
        val updateServiceRequest = UpdateServiceRequest()
        updateServiceRequest.cluster = CLUSTER
        updateServiceRequest.service = SERVICE
        updateServiceRequest.taskDefinition = buildTaskDef(image!!).taskDefinition.taskDefinitionArn
        val updateServiceResult = ecs.updateService(updateServiceRequest)
        return updateServiceResult.service.serviceArn
    }

    fun buildTaskDef(image: String): RegisterTaskDefinitionResult {
        val request = ListTaskDefinitionsRequest()
        request.familyPrefix = TASK_FILTER
        request.sort = SORT_DIR
        request.maxResults = 1

        val definitions = ecs.listTaskDefinitions(request)
        val definition = definitions.taskDefinitionArns[0]

        val describeTaskDefinitionRequest = DescribeTaskDefinitionRequest()
        describeTaskDefinitionRequest.taskDefinition = definition

        val latestDef = ecs.describeTaskDefinition(describeTaskDefinitionRequest).taskDefinition

        val registerTaskDefinitionRequest = RegisterTaskDefinitionRequest()
        registerTaskDefinitionRequest.family = latestDef.family
        registerTaskDefinitionRequest.taskRoleArn = latestDef.taskRoleArn
        registerTaskDefinitionRequest.networkMode = latestDef.networkMode

        latestDef.containerDefinitions.first().image = image
        registerTaskDefinitionRequest.containerDefinitions.addAll(latestDef.containerDefinitions)
        registerTaskDefinitionRequest.volumes.addAll(latestDef.volumes)
        registerTaskDefinitionRequest.placementConstraints.addAll(latestDef.placementConstraints)

        return ecs.registerTaskDefinition(registerTaskDefinitionRequest)
    }
}