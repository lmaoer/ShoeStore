package model;

import java.awt.Checkbox;

public class Customer {
	private int id;
	private String name, phone, city, username, password;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, String phone, String city, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.username = username;
		this.password = password;
	}

	public Customer(String name, String phone, String city, String username, String password) {
		super();
		this.name = name;
		this.phone = phone;
		this.city = city;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
	
	
}
