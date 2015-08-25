<div id="productSummary">
	<span class="name">${product.name}</span>
	<g:link controller="product" action="show" id="${product.id}">
		<img src='<g:createLinkTo dir="images/chairs" file="${product.img}" />' />
	</g:link>
</div>