package com;

import java.io.Serializable;

public class Packet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String message;
	public Packet(String m) {
		message = m;
	}
	
	public String getString() {
		return message;
	}
}
