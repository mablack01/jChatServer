package com;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class User implements Runnable {

	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket socket;
	
	public User(Socket s) {
		socket = s;
	}
	
	@Override
	public void run() {
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			//so by now, object streams on both server and client for this connection are init
			//its time to handle receiving/sending data
			
			while(true) {
				 Object data = in.readObject(); //client does writeObject(object);
				 
				 if(data instanceof String) {
					 //now we know that data is a String
				 }
				 if(data instanceof User) {
					 //now we know its a user
				 }
			}
			
		}catch(Exception e) { }
	}
	
	
}
