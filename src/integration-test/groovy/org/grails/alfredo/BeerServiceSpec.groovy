package org.grails.alfredo

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BeerServiceSpec extends Specification {

    BeerService beerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Beer(...).save(flush: true, failOnError: true)
        //new Beer(...).save(flush: true, failOnError: true)
        //Beer beer = new Beer(...).save(flush: true, failOnError: true)
        //new Beer(...).save(flush: true, failOnError: true)
        //new Beer(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //beer.id
    }

    void "test get"() {
        setupData()

        expect:
        beerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Beer> beerList = beerService.list(max: 2, offset: 2)

        then:
        beerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        beerService.count() == 5
    }

    void "test delete"() {
        Long beerId = setupData()

        expect:
        beerService.count() == 5

        when:
        beerService.delete(beerId)
        sessionFactory.currentSession.flush()

        then:
        beerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Beer beer = new Beer()
        beerService.save(beer)

        then:
        beer.id != null
    }
}
