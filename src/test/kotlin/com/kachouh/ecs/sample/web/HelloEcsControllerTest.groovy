package com.kachouh.ecs.sample.web

import spock.lang.Specification

class HelloEcsControllerTest extends Specification {
    def "HelloEcs"() {
        given:
          def name = "test"
        when:
          def result = new HelloEcsController().helloEcs(name)
        then:
          result == "Hello, " + name
    }
}
