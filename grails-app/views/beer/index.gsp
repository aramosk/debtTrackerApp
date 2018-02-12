<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'beer.label', default: 'Beer')}" />
        <title><g:message code="beer.table.title"/></title>
    </head>
    <body>
        <a href="#list-beer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="debt.new.label" /></g:link></li>
            </ul>
        </div>
        <div id="list-beer" class="content scaffold-list" role="main">
            <h1><g:message code="beer.table.title"/></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${beerList}" properties="['id', 'giver', 'amount', 'receiver']"/>

            <div class="pagination">
                <g:paginate total="${beerCount ?: 0}" />
            </div>
        </div>
    </body>
</html>