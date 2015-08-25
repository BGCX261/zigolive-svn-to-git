class ApplicationBootStrap {

     def init = { servletContext ->
     	new SiteMap(pages:[new Page(title:"HomePage",url:"HomePage.html")]).save()
     	new Product(name:"Product 1",desc:"Product is a desk",img:"images_001.jpg",price:99).save()
     	new Product(name:"Product 2",desc:"Product is not a desk",img:"images_002.jpg",price:999).save()
     	new Product(name:"Product 3",desc:"Product might be a desk",img:"images_003.jpg",price:9999).save()
		new Admin(username:"james",password:"james").save()     	
     }
     def destroy = {
     }
} 