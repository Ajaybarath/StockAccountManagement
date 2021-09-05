package com.bridgelabz.stockManagement;

import java.util.ArrayList;

public class Stock {

	private String name;
	private int noOfShares;
	private int price;

	ArrayList<String> transaction;

	public Stock(String name, int noOfShares, int price) {
		super();
		this.name = name;
		this.noOfShares = noOfShares;
		this.price = price;
		transaction = new ArrayList<>();
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

	@Override
	public String toString() {
		return "Stock [name=" + name + ", noOfShares=" + noOfShares + ", price=" + price + "]";
	}

	public ArrayList<String> getTransaction() {
		return transaction;
	}

	public void setTransaction(String data) {
		transaction.add(data);
	}

}
