package com.kachouh.ecs.sample.ecs


import spock.lang.Requires
import spock.lang.Specification

import static java.lang.System.getenv

class UpdateServiceTest extends Specification {

    @Requires({ env["accessKey"] })
    def "Loads task definitions"() {
        given:
          def ecs = new EcsClientWiring().amazonECS(getenv()["accessKey"], getenv()['secret'])
          def updateService = new UpdateService(ecs)
        when:
          def result = updateService.update()
        then:
          result
    }
}
