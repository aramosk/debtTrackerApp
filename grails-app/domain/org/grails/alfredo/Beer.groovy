package org.grails.alfredo

class Beer {

    Member giver
    Member receiver
    Date dateCreated
    int amount

    static constraints = {
        amount min: 1
    }
}
