package com.czq.shop.model;

public class OderProductModel {
	private int orderId;			//订单ID
	private int productId;			//商品ID
	private double transactionPrice;//成交价格
	private int number;				//购买数量
	/**
	 * @return orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId 要设置的 orderId
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId 要设置的 productId
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * @return transactionPrice
	 */
	public double getTransactionPrice() {
		return transactionPrice;
	}
	/**
	 * @param transactionPrice 要设置的 transactionPrice
	 */
	public void setTransactionPrice(double transactionPrice) {
		this.transactionPrice = transactionPrice;
	}
	/**
	 * @return number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number 要设置的 number
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
}
