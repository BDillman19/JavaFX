package com.bryce.classes;

public class Income {
	private String name;
	private String amount;
	private String id;
	
	public Income(final String name, final String amount, final String id) {
		this.name = name;
		this.amount = amount;
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	
	public String getAmount() {
		return this.amount;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public void setAmount(final String amount) {
		this.amount = amount;
	}
}
