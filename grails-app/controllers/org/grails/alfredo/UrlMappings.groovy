package org.grails.alfredo

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //REST call
        "/debts/$giver?"(controller: "debt", action: "retrieveDebts")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
