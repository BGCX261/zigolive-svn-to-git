<html>
    <head>
        <meta name="layout" content="default"></meta>
    </head>
    <body>

		<g:each var="product" in="${productList}">
			<g:render template="summaryView" model="['product':product]"/>
		</g:each>    
    
    </body>
</html>

