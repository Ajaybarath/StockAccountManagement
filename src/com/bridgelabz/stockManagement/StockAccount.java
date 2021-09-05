package com.bridgelabz.stockManagement;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.bridgeLabz.linkedList.MyLinkedList;
import com.bridgeLabz.linkedList.MyNode;
import com.bridgeLabz.queue.MyQueue;
import com.bridgeLabz.stacks.MyStack;

public class StockAccount {

	Map<String, Stock> stockList;

	MyQueue<String> txnDateTime;
	MyStack<String> stockTxnList;

	StockAccount() {
		stockList = new HashMap<>();
		txnDateTime = new MyQueue<>();
		stockTxnList = new MyStack<>();
	}
	
	public static void main(String args[]) {

		StockAccount stockAccount = new StockAccount();
		Stock stock1 = new Stock("idea", 10, 2256);
		Stock stock2 = new Stock("rel", 33, 1200);
		Stock stock3 = new Stock("artl", 50, 233);
		Stock stock4 = new Stock("tata", 20, 323);
		
		stockAccount.stockList.put(stock1.getName(), stock1);
		stockAccount.stockList.put(stock2.getName(), stock2);
		stockAccount.stockList.put(stock3.getName(), stock3);
		stockAccount.stockList.put(stock4.getName(), stock4);
		
		stockAccount.printReport();

		System.out.println(stockAccount.valueOf());

		stockAccount.buy(5, "idea");
		stockAccount.buy(10, "artl");
		stockAccount.sell(5, "tata");
		
		stockAccount.printReport();

		System.out.println(stockAccount.valueOf());
		

	}

	private int calculatePrice(Stock stock) {
		return stock.getPrice() * stock.getNoOfShares();
	}

	private double valueOf() {
		double totalValue = 0;
		for (Stock stock : stockList.values()) {
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
			txnDateTime.add(new MyNode<String>("BUY " + symbol + " " + dateTime));
			stockTxnList.push(new MyNode<String>("BUY" + symbol));
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
				txnDateTime.add(new MyNode<String>("SELL " + symbol + " " + dateTime));
				stockTxnList.push(new MyNode<String>("SELL " + symbol));
				stock.setTransaction("SELL " + dateTime);
				stockList.put(symbol, stock);
			} else {
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
