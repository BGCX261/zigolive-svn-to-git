class ProductController extends ProtectedController{

	def scaffold = true
	def defaultAction = "list"
	def show={
		[product:Product.get(params["id"])]	
	}
	def list={
		[productList:Product.findAll()]	
	}
}

