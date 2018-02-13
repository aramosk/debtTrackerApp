<html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Debt tracker</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Debt tracker</h1>
    </section>

    <ul class="list-group">
        <li class="list-group-item">
            <g:link controller="member" action="index">Manage members</g:link>
        </li>
        <li class="list-group-item">
            <g:link controller="beer" action="index">Manage debts</g:link>
        </li>
        <li class="list-group-item">
            <g:link controller="debt" action="retrieveDebts">REST call to retrieve debts info in JSON</g:link>
        </li>
        <li class="list-group-item">
            <g:link controller="debt" action="retrieveDebts" params="[giver:'1']">REST call to retrieve debts owed by member with id=1 in JSON</g:link>
        </li>
    </ul>

</div>

</body>
</html>