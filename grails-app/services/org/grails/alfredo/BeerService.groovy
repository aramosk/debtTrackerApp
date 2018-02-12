package org.grails.alfredo

import grails.gorm.services.Service

@Service(Beer)
interface BeerService {

    Beer get(Serializable id)

    List<Beer> list(Map args)

    Long count()

    void delete(Serializable id)

    Beer save(Beer beer)

}