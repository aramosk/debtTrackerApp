package org.grails.alfredo

class Member {

    String name
    String email
    Date birthdate

    static constraints = {
        email email: true
        name maxSize: 255
        birthdate validator: {
            val ->
                return val.before(new Date())
        }
    }

    String toString() {
        name
    }
}
