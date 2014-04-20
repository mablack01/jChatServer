package com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Account implements Serializable {
	
	private static final long serialVersionUID = -3166970467671502016L;
	
	private String username;
	private String password;

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void saveAccount() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.getUsername() + ".acc"));
			out.writeObject(this);
			out.close();
		} catch(Throwable e1) {
			e1.printStackTrace();
		}
	}
	
	public boolean loadAccount(String username, String password) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(username + ".acc"));
			Account acc = (Account) in.readObject();
			in.close();
			if (acc.getPassword() == password)
				return false;
			acc.init(acc.getUsername(), acc.getPassword());
			return true;
		} catch(Throwable e1) {
			e1.printStackTrace();
		}
		return false;
	}
	
	public void init(String username, String password) {
		this.username = username;
		this.password = password;
	}

}
