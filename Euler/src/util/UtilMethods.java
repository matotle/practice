package util;

import java.util.Scanner;

public class UtilMethods {


/**
 * Static method to ask the user if they wish to enter custom input for console
 * @return boolean true if' yes'
 */
public static boolean useCustomInputConsole() {
	boolean b=false;
	String s;
	System.out.println("Enter 'y' if you wish to run custom input, otherwise enter any other key");
	@SuppressWarnings("resource")//If closed it here, it seems to cause issues so ignoring it for now.
	Scanner keyboard = new Scanner(System.in);
	s=keyboard.nextLine();
	if("y".equalsIgnoreCase(s)) {
		b=true;
	}
	
	return b;
	
}
	
}
