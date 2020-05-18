package model;

import java.io.Serializable;

import utils.IdFactory;

@SuppressWarnings("serial")
public class User implements Serializable {

	private int id;
	private String name;
	private String username;
	private String password;

	public User(String name, String username, String password) {
		super();
		if (!name.trim().isEmpty() && !username.trim().isEmpty() && !password.trim().isEmpty()) {
			this.id = IdFactory.incrementI();
		} else {
			this.id = -1;
		}
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public User(int id, String name, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}

}
