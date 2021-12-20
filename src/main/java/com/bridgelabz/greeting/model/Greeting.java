package com.bridgelabz.greeting.model;

public class Greeting {
	private String content;
	private long id;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;

	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}