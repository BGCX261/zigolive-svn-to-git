import java.util.logging.Level;
import java.util.logging.Logger;


public class test {

	public static void main(String[] args) {
		Logger l = Logger.getLogger("debug");
		l.setLevel(Level.ALL);
		l.severe("Doing stuff");
		
		
	}
}
