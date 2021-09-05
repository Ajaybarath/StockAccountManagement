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
		if (stockList.containsKey(symbol)) {
			Stock stock = stockList.get(symbol);
			int shareCount = stock.getNoOfShares();
			shareCount += amount;
			stock.setNoOfShares(shareCount);
			stockList.put(symbol, stock);
		}

		System.out.println(amount + symbol + " shares bought ");
	}
	
	void sell(int amount, String symbol) {
		if (stockList.containsKey(symbol)) {
			Stock stock = stockList.get(symbol);
			int shareCount = stock.getNoOfShares();
			if (shareCount >= amount) {
				shareCount -= amount;
				stock.setNoOfShares(shareCount);
				stockList.put(symbol, stock);
			}
			else {
				System.out.println("Not enough shares availaible to sell");
				return;
			}
			
		}

		System.out.println(amount + symbol + " shares sold ");
	}
	
	void printReport() {
		
	}

}
