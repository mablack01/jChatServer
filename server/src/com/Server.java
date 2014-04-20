package com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final int port = 1597; 
	private static ServerSocket ss;
	
	public static void main(String[] args) {
		try {
			ss = new ServerSocket(port); 
			
			while(true) {
				User user = new User(ss.accept()); //accept connection
				Thread thread = new Thread(user); //create thread to handle sending/receiving stuff
				thread.start(); //start it
				System.out.println("connection accepted!"); //restart
			}
		}catch(IOException e) { } //IOException == In/Out exception
	}
}


