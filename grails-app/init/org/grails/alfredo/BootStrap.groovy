package org.grails.alfredo

import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->

        //Register Member domain for JSON rendering
        JSON.registerObjectMarshaller(Member) {
            def output = [:]
            output['id'] = it.id
            output['name'] = it.name
            output['email'] = it.email

            return output;
        }

        //Register Beer domain for JSON rendering
        JSON.registerObjectMarshaller(Beer) {
            def output = [:]
            output['id'] = it.id
            output['giver'] = it.giver
            output['amount'] = it.amount
            output['receiver'] = it.receiver
            output['dateCreated'] = it.dateCreated

            return output;
        }

        def ernst = new Member(name: 'Ernst', email: 'ernst@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd', '1970-05-12')).save()
        def mathijs = new Member(name: 'Mathijs', email: 'mathijs@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd','1974-04-11')).save()
        def alfredo = new Member(name: 'Alfredo', email: 'alfredo@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd','1977-08-16')).save()
        def ronald = new Member(name: 'Ronald', email: 'ronald@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd','1980-06-12')).save()
        def kevin = new Member(name: 'Kevin', email: 'kevin@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd','1981-07-15')).save()
        def alexandra = new Member(name: 'Alexandra', email: 'alexandra@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd','1984-03-14')).save()
        def mike = new Member(name: 'Mike', email: 'mike@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd','1984-03-14')).save()

        def ernstOwesAlfredo = new Beer(giver: ernst, receiver: alfredo, amount: 5).save()
        def AlfredoOwesErnst = new Beer(giver: alfredo, receiver: ernst, amount: 3).save()
        def ronaldToKevin = new Beer(giver: ronald, receiver: kevin, amount: 7).save()
        def kevinOwesRonald = new Beer(giver: kevin, receiver: ronald, amount: 10).save()
        def alexandraOwesMike = new Beer(giver: alexandra, receiver: mike, amount: 4).save()
        def mikeOwesAlexandra = new Beer(giver: mike, receiver: alexandra, amount: 8).save()
        def mathijsOwesRonald = new Beer(giver: mathijs, receiver: ronald, amount: 10).save()
        def ronaldOwesmathijs = new Beer(giver: ronald, receiver: mathijs, amount: 9).save()

    }
    def destroy = {
    }
}
