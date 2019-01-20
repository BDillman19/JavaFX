package com.bryce.classes;

public class Expense {
	private String name;
	private String cost;
	private String id;
	
	public Expense(final String name, final String cost, final String username) {
		this.name = name;
		this.cost = cost;
		this.id = username;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCost() {
		return this.cost;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setName(final String newName) {
		this.name = newName;
	}
	
	public void setCost(final String newCost) {
		this.cost = newCost;
	}
}
