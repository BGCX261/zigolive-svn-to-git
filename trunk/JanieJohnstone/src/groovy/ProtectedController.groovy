

class ProtectedController {

	def beforeInterceptor = [action:this.&auth, except:['index','list','show']]
		                    	
  	def auth() {
  		if(!session.user){
  			print "Not logged in"
  			redirect(controller:'admin', action:'login')
  			return false
  		}
  	}
                     	
}