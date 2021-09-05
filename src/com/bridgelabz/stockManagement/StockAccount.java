package com.bridgelabz.stockManagement;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.bridgeLabz.linkedList.MyLinkedList;
import com.bridgeLabz.linkedList.MyNode;
import com.bridgeLabz.queue.MyQueue;

public class StockAccount {
	
	Map<String, Stock> stockList;
	
	MyQueue<String> txnDateTime;
	
	StockAccount() {
		stockList = new HashMap<>();
		txnDateTime = new MyQueue<>();
	}
	
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
			LocalDateTime dateTime = LocalDateTime.now();
			txnDateTime.add(new MyNode<String>("BUY " + dateTime));
			stock.setTransaction("BUY " + dateTime);
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
				LocalDateTime dateTime = LocalDateTime.now();
				txnDateTime.add(new MyNode<String>("SELL " + dateTime));
				stock.setTransaction("SELL " + dateTime);
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
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "StockAccount [stockList=" + stockList + "]";
	}
	
	
	

}
