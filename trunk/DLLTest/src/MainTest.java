import java.io.IOException;

import sun.misc.ServiceConfigurationError;

import com.eaio.nativecall.IntCall;
import com.eaio.nativecall.NativeCall;

/**
 * 
 * @author Tim Fletcher
 *
 */
public class MainTest {
	public static void main(String[] args) {
		try {
			NativeCall.init();
			IntCall status = new IntCall("K8061","OpenDevice");
			int res = status.executeCall();
			//res = 0;
			switch(res){
				case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7:
					System.out.println("Found card with ID "+res+".");
					break;
				case -2:
					System.out.println("No cards found. Check the USB connections and power supply.");
					break;
				case -1:
					System.out.println("All Cards regestered");
					break;
			}			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsatisfiedLinkError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
