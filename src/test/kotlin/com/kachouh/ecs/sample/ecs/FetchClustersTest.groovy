package com.kachouh.ecs.sample.ecs

import com.amazonaws.services.ecs.AmazonECS
import spock.lang.Specification

class FetchClustersTest extends Specification {
    def "Assert that it calls list clusters"() {
        given:
          def client = Mock(AmazonECS)
          def underTest = new FetchClusters(client)
        when:
          underTest.fetch()
        then: "verify it invokes listClusters"
          1 * client.listClusters()
    }
}
