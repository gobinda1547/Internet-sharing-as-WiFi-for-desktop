package org.ju.cse.gobinda;

import java.io.IOException;
import java.util.Scanner;

public class ComputerManager {

	public static void setUsernamePassword(String userName, String passWord) {
		processCommandAndShowInfo("netsh wlan set hostednetwork mode=allow ssid="+userName+" key="+passWord);
	}

	public static void makeSharingOn() {
		processCommandAndShowInfo("netsh wlan start hostednetwork");
	}

	public static void makeSharingOff() {
		processCommandAndShowInfo("netsh wlan stop hostednetwork");
	}

	private static void processCommandAndShowInfo(String command) {
		try {
			Process p = Runtime.getRuntime().exec(command);
			Scanner scanner = new Scanner(p.getInputStream());
			StringBuilder output = new StringBuilder();
			while (scanner.hasNextLine()) {
				output.append(scanner.nextLine() + "\n");
			}
			WifiShare.showInformation(output.toString());
			scanner.close();
		} catch (IOException e) {
			WifiShare.showInformation("Error Occurs.\nwhile processing this command\n" + command);
		}
	}

}
