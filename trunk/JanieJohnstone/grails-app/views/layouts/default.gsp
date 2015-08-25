<html>
      <head>
          <title><g:layoutTitle default="An example decorator" /></title>
          <style>
          #productFull {border-style: solid;border-color: #0000ff}
          #productSummary {border-style: solid;border-color: #FF0000}
          
          #top {width:100%;background-color:#999999;}
          #menu {float:left;height:300px;}
          #content {float:left;background-color:#ffff99;}
          #image {float:left;}
          </style>
          <g:layoutHead />
      </head>
      <body>
      	<div id="top">Main Top Banner</div>
      	<div id="menu">
      		<ul>
      			<li>Item 1</li>
      			<li>Item 1</li>
      			<li>Item 1</li>
      			<li>Item 1</li>
      		</ul>
      		<g:form url="[action:'doLogin',controller:'admin']" >
      		username:<g:textField name="username" /><br/>
      		password:<g:textField name="password" /><br/>
      		<input type="submit" value="login"/>
      		</g:form>
      	</div>
      	<div id="content">
		  <g:layoutBody />
		</div>
      </body>
</html>