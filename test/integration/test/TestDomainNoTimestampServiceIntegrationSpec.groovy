package test

import grails.plugin.spock.IntegrationSpec
import groovy.time.TimeCategory

import org.grails.plugins.timetravel.TimeTravel

@Mixin(TimeTravel)
class TestDomainNoTimestampServiceIntegrationSpec extends IntegrationSpec {
    def testDomainNoAutotimestampService

    def setupSpec() {
        Integer.mixin(TimeCategory)
    }

    void 'Test save domain object'() {
        when:
            travel(10.years.ago) {
                testDomainNoAutotimestampService.insertDomainObject(name, value)
            }
            def result = TestDomainNoAutotimestamp.findByName(name)

        then:
            result != null
            result.dateCreated == null
            result.lastUpdated == null

        where:
            name = "test"
            value = 10
    }
}
