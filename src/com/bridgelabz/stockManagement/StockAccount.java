package com.bridgelabz.stockManagement;

import java.util.Map;

public class StockAccount {
	
	Map<String, Stock> stockList;
	
	
	private int calculatePrice(Stock stock) {
		return stock.getPrice() * stock.getNoOfShares();
	}
	
	private double valueOf() {
		double totalValue = 0;
		for (Stock stock: stockList.values()) {
			totalValue += calculatePrice(stock);
		}
		
		return totalValue;
	}

	
	void buy(int amount, String symbol) {
		
		
	}
	
	void sell(int amount, String symbol) {
		
	}
	
	void printReport() {
		
	}

}
