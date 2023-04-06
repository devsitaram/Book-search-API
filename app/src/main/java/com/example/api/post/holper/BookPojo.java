package com.example.api.post.holper;

public class BookPojo {
	private String name;
	private boolean available;
	private int id;
	private String type;

	public BookPojo(String name, boolean available, int id, String type) {
		this.name = name;
		this.available = available;
		this.id = id;
		this.type = type;
	}

	public String getName(){
		return name;
	}

	public boolean isAvailable(){
		return available;
	}

	public int getId(){
		return id;
	}

	public String getType(){
		return type;
	}
}
