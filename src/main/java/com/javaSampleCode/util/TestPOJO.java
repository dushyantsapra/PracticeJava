package com.javaSampleCode.util;

public class TestPOJO {
	private int id;
	private String name;

	public TestPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestPOJO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "TestPOJO [id=" + id + ", name=" + name + "]";
	}

}