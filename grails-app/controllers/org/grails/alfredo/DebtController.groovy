package org.grails.alfredo

import grails.converters.JSON
import grails.rest.*

/**
 * @author aramosk
 */
class DebtController extends RestfulController {

    static responseFormats = ['json']

    DebtController() {
        super(Beer)
    }

    def retrieveDebts() {
        def giver = params.giver

        if (giver == null) {
            render Beer.findAll() as JSON
        } else {
            render Beer.findAll("from Beer as b where b.giver.id=?", [params.giver.toLong()]) as JSON
        }

    }

}
