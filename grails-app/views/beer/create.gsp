<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'beer.label', default: 'Beer')}" />
        <title><g:message code="debt.new.label"/></title>
    </head>
    <body>
        <a href="#create-beer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="debt.entries.label"/></g:link></li>
            </ul>
        </div>
        <div id="create-beer" class="content scaffold-create" role="main">
            <h1><g:message code="debt.new.label"/></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.beer}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.beer}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.beer}" method="POST">
                <fieldset class="form">
                    <f:with bean="beer">
                        <f:field property="giver"/>
                        <f:field property="receiver"/>
                        <f:field property="amount"/>
                    </f:with>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
