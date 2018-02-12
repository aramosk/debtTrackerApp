package org.grails.alfredo

class BootStrap {

    def init = { servletContext ->

        def ernst = new Member(name: 'Ernst', email: 'ernst@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd', '1970-05-12')).save()
        def mathijs = new Member(name: 'Mathijs', email: 'mathijs@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd','1974-04-11')).save()
        def alfredo = new Member(name: 'Alfredo', email: 'alfredo@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd','1977-08-16')).save()
        def ronald = new Member(name: 'Ronald', email: 'ronald@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd','1980-06-12')).save()
        def kevin = new Member(name: 'Kevin', email: 'kevin@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd','1981-07-15')).save()
        def alexandra = new Member(name: 'Alexandra', email: 'alexandra@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd','1984-03-14')).save()
        def mike = new Member(name: 'Mike', email: 'mike@geckotech.nl', birthdate: Date.parse('yyyy-MM-dd','1984-03-14')).save()

        def ernstOwesAlfredo = new Beer(giver: ernst, receiver: alfredo, amount: 5).save()
        def AlfredoOwesErnst = new Beer(giver: alfredo, receiver: ernst, amount: 3).save()
        def ronaldToKevin = new Beer(giver: ronald, receiver: kevin, amount: 5).save()
        def kevinOwesRonald = new Beer(giver: kevin, receiver: ronald, amount: 3).save()

    }
    def destroy = {
    }
}
