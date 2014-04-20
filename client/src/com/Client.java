package com;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client  {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 1597); 
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			//so by now, object streams on both server and client for this connection are init
			//its time to handle receiving/sending data
			
			Scanner scanner = new Scanner(System.in); 
			
			while(true) {
				String message = scanner.nextLine();
				
				if(message.length() > 0) { //make sure theres text
					out.writeObject(new Packet(message)); 
				}
			}
			
		}catch(IOException e) { }
	}
}

