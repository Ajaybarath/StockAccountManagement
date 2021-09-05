package com.bridgelabz.stockManagement;

public class Stock {

	private String name;
	private int noOfShares;
	private int price;

	public Stock(String name, int noOfShares, int price) {
		super();
		this.name = name;
		this.noOfShares = noOfShares;
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getNoOfShares() {
		return noOfShares;
	}

	public int getPrice() {
		return price;
	}

}
