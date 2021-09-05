package com.bridgelabz.stockManagement;

import java.util.HashMap;
import java.util.Map;

public class StockPortfolio {

	Map<String, Stock> stockList;
	
	public StockPortfolio() {
		this.stockList = new HashMap<>();
	}

	public static void main(String args[]) {

		Stock stock1 = new Stock("idea", 10, 2256);
		Stock stock2 = new Stock("rel", 33, 1200);
		Stock stock3 = new Stock("artl", 50, 233);
		Stock stock4 = new Stock("tata", 20, 323);

		StockPortfolio stockPortfolio = new StockPortfolio();

		stockPortfolio.add(stock1);
		stockPortfolio.add(stock2);
		stockPortfolio.add(stock3);
		stockPortfolio.add(stock4);
		
		System.out.println("Total stock portfolio is : " + stockPortfolio.getTotalPrice());
		
		System.out.println(stockPortfolio.toString());

	}

	private void add(Stock stock) {

		stockList.put(stock.getName(), stock);

	}
	
	private int calculatePrice(Stock stock) {
		return stock.getPrice() * stock.getNoOfShares();
	}
	
	private int getTotalPrice() {
		int totalValue = 0;
		for (Stock stock: stockList.values()) {
			totalValue += calculatePrice(stock);
		}
		
		return totalValue;
	}

	@Override
	public String toString() {
		return "StockPortfolio [stockList=" + stockList + "]";
	}
	
	

}
