package com.example.billingbackend.dao;



public class ApiDataRecever {
	
	private int id;
	
	private String data;

	
	public ApiDataRecever(int id, String data) {
		super();
		this.id = id;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}  
	
	
	

}
