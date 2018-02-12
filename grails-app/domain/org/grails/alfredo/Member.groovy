package org.grails.alfredo

class Member {

    String name
    String email
    Date birthdate

    static constraints = {
        email email: true
        name maxSize: 255
    }
}
