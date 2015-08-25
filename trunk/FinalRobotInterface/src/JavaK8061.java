import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.Logger;

import sun.misc.ServiceConfigurationError;

import com.eaio.nativecall.IntCall;
import com.eaio.nativecall.NativeCall;
import com.eaio.nativecall.VoidCall;


public class JavaK8061 {

	private static Logger slog = Logger.getLogger("Default");
	static {
		//slog.setLevel(Level.OFF);
		try {
			NativeCall.init();
			slog.info("Found NativeCall");
		} catch (SecurityException e) {
			slog.severe("The current security configuration doesn't allow loading system dlls\nEither dissable the security manager, or modify it to except loading system dlls at runtime");
		} catch (UnsatisfiedLinkError e) {
			slog.severe("Native Call can't find the NativeCall.dll file. Make sure it is in a windows system folder, or in the same directory as this program");
		} catch (UnsupportedOperationException e) {
			slog.severe("Native Call encountered an unsupported operation");
		} catch (IOException e) {
			slog.severe("There is an IO exception, check that all the files are where they should be and check permissions on thoses files");
		} catch (ServiceConfigurationError e) {
			slog.severe("There was a service configuration error");
		}
	}
	private static final String DLLNAME = "K8061";
	private Logger log;
	private int cardID;
	public JavaK8061(){
		openDevice();

		log = Logger.getLogger(DLLNAME+"_Card"+cardID);
		
		switch(cardID){
			case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7:
				log.info("Found card with id "+cardID);
				break;
			case -2:
				log.warning("No cards found. Check the USB connections and power supply.");
				//System.out.println("No cards found. Check the USB connections and power supply.");
				cardID=-1;
				break;
			case -1:
				cardID=-1;
				log.info("All cards regestered");
				//System.out.println("All Cards regestered");
				break;
		}
	}

	private boolean isValidCardID(){
		if(cardID>=0) return true;
		return false;
	}
	public int getCardID(){
		return cardID;
	}
	
	public void closeDevice(){
		if(!isValidCardID()) slog.severe("Current card ID is not valid, please ignore possitive results from this call");
		VoidCall closeDevice = new VoidCall(DLLNAME,"CloseDevice");
		closeDevice.executeCall();
	}
	public void openDevice(){
		IntCall openDevice = new IntCall(DLLNAME,"OpenDevice");
		cardID = openDevice.executeCall();
		if(!isValidCardID()) slog.severe("Current card ID is not valid, please ignore possitive results from this call");
	}
	public boolean powerGood(){
		if(!isValidCardID()) log.severe("Current card ID is not valid, please ignore possitive results from this call");
		IntCall powerGood = new IntCall(DLLNAME, "PowerGood");
		boolean b =powerGood.executeBooleanCall(new Object[]{cardID});
		if(b) log.info("Power to card "+cardID+" is good");
		else  log.warning("Card "+cardID+" power supply isn't working");
		return b;
	}
	public boolean connected(){
		if(!isValidCardID()) log.severe("Current card ID is not valid, please ignore possitive results from this call");
		IntCall connected = new IntCall(DLLNAME, "Connected");
		boolean c =connected.executeBooleanCall(new Object[]{cardID});
		if(c) log.info("Card "+cardID+" is connected");
		else  log.warning("Card "+cardID+" isn't connected");
		return c;
	}
	public int[] readAllAnalog(){
		
		VoidCall connected = new VoidCall(DLLNAME, "ReadAllAnalog");
		int[] ret = new int[7];
		connected.executeCall(new Object[]{cardID, ret});
		return ret;
	}
	
	public static void main(String[] args) {
		JavaK8061 jcard = new JavaK8061();
		jcard.powerGood();		
		jcard.connected();
		jcard.readAllAnalog();
	}
}
