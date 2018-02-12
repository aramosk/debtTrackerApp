package org.grails.alfredo

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BeerController {

    BeerService beerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond beerService.list(params), model:[beerCount: beerService.count()]
    }

    def show(Long id) {
        respond beerService.get(id)
    }

    def create() {
        respond new Beer(params)
    }

    def save(Beer beer) {
        if (beer == null) {
            notFound()
            return
        }

        try {
            beerService.save(beer)
        } catch (ValidationException e) {
            respond beer.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'beer.label', default: 'Beer'), beer.id])
                redirect beer
            }
            '*' { respond beer, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond beerService.get(id)
    }

    def update(Beer beer) {
        if (beer == null) {
            notFound()
            return
        }

        try {
            beerService.save(beer)
        } catch (ValidationException e) {
            respond beer.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'beer.label', default: 'Beer'), beer.id])
                redirect beer
            }
            '*'{ respond beer, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        beerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'beer.label', default: 'Beer'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'beer.label', default: 'Beer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
