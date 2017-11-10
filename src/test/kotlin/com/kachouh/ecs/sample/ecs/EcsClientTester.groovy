package com.kachouh.ecs.sample.ecs

import com.amazonaws.services.ecs.model.DescribeTaskDefinitionRequest
import com.amazonaws.services.ecs.model.ListTaskDefinitionsRequest
import com.kachouh.ecs.sample.EcsClientWiring
import spock.lang.Requires
import spock.lang.Specification

import static java.lang.System.getenv

class EcsClientTester extends Specification {

    @Requires({ env["accessKey"] })
    def "Loads task definitions"() {
        given:
          def ecs = new EcsClientWiring().amazonECS(getenv()["accessKey"], getenv()['secret'])
        expect:
          ecs.listTaskDefinitions()
    }

    @Requires({ env["accessKey"] })
    def "Loads latest definitions"() {
        given:
          def ecs = new EcsClientWiring().amazonECS(getenv()["accessKey"], getenv()['secret'])
          def request = new ListTaskDefinitionsRequest()
          request.familyPrefix = "ecs-sample-task"
          request.sort = 'DESC'
          request.maxResults = 1
        when:
          def definitions = ecs.listTaskDefinitions(request)
          def definition = definitions.taskDefinitionArns[0]
          def latest = ecs.describeTaskDefinition(new DescribeTaskDefinitionRequest(taskDefinition: definition))
        then:
          latest
          latest.taskDefinition
          latest.taskDefinition.containerDefinitions.size() > 0
          latest.taskDefinition.family == 'ecs-sample-task'
          latest.taskDefinition.containerDefinitions[0]
    }
}
