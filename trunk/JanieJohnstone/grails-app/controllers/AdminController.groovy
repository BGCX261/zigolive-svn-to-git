class AdminController extends ProtectedController{

	def index = { }
	def beforeInterceptor = [action:this.&auth, except:['index','list','show','doLogin','login']]
	                     	
	def doLogin = {
	    	print params
	    	def admin = Admin.findWhere(username:params['username'], password:params['password'])
	    	if(admin){
	    		session.user = admin
	    		redirect(controller:'product', action:'list')
	    	}else redirect(controller:'product', action:'list')
	    }
	def login = {
			[]
	}
}

