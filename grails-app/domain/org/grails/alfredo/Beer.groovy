package org.grails.alfredo

class Beer {

    Member giver
    Member receiver
    Date dateCreated
    int amount

    static constraints = {
        amount min: 1
        giver unique: ['receiver'], nullable: false,
                //giver and receiver cannot be the same
                validator: {val, obj ->
                               if (val.id == obj.receiver.id) {
                                  return ["invalid.giverCannotBeEqualToReceiver.label"]
                               }
                           }

    }
}
