import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Tracker {
	static int port = 0;
	
	public static void main(String args[]) {
            Scanner inDatos = new Scanner(System.in);
                System.out.print("Puerto para el Tracker: ");
                port = inDatos.nextInt();
		
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		TrackerListener listen = new TrackerListener(port);
		listen.start();
		String userInput;
		try {
			while (listen.isAlive()){ 
					if ((userInput = stdIn.readLine()) != null && userInput.equalsIgnoreCase("Exit")){
						listen.interrupt(); //finaliza el tracker
						break;
					}
			}
		} catch (IOException e){
			System.out.println("- Tracker: IOException!\nCerrando...");
			System.exit(1);
		}
	}
	
}
