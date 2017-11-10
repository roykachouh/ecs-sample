package com.kachouh.ecs.sample.web

import spock.lang.Specification

class HelloEcsControllerTest extends Specification {
    def "Assert that it returns the correct hydrated object"() {
        given:
          def name = "test"
        when:
          def result = new HelloEcsController().helloEcs(name)
        then:
          result.name == name
          result.hostname
    }
}
