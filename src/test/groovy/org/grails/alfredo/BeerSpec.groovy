package org.grails.alfredo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class BeerSpec extends Specification implements DomainUnitTest<Beer> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
