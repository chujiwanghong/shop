package com.czq.shop.model;

import java.util.Date;

public class OrderFormModel {
	private int orderId;			//订单ID
	private String merchant;		//商家名
	private String userName;		//用户名
	private Date orderTime;			//下单时间
	private Date payTime;			//付款时间
	private Date deliverTime;		//发货时间
	private Date receiptTime;		//收货时间
	private Date getTime;			//收款时间
	private String address;			//收货地址
	private String xpressCompany;	//快递公司
	private long xpressNumber;		//快递单号
	private double totalPrice;		//订单总价
	private int status;				//订单状态
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
	 * @return merchant
	 */
	public String getMerchant() {
		return merchant;
	}
	/**
	 * @param merchant 要设置的 merchant
	 */
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName 要设置的 userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return orderTime
	 */
	public Date getOrderTime() {
		return orderTime;
	}
	/**
	 * @param orderTime 要设置的 orderTime
	 */
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	/**
	 * @return deliverTime
	 */
	public Date getDeliverTime() {
		return deliverTime;
	}
	/**
	 * @param deliverTime 要设置的 deliverTime
	 */
	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}
	/**
	 * @return receiptTime
	 */
	public Date getReceiptTime() {
		return receiptTime;
	}
	/**
	 * @param receiptTime 要设置的 receiptTime
	 */
	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address 要设置的 address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return xpressCompany
	 */
	public String getXpressCompany() {
		return xpressCompany;
	}
	/**
	 * @param xpressCompany 要设置的 xpressCompany
	 */
	public void setXpressCompany(String xpressCompany) {
		this.xpressCompany = xpressCompany;
	}
	/**
	 * @return xpressnumber
	 */
	public long getXpressNumber() {
		return xpressNumber;
	}
	/**
	 * @param xpressnumber 要设置的 xpressnumber
	 */
	public void setXpressNumber(long xpressNumber) {
		this.xpressNumber = xpressNumber;
	}
	/**
	 * @return totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice 要设置的 totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * @return status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status 要设置的 status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return payTime
	 */
	public Date getPayTime() {
		return payTime;
	}
	/**
	 * @param payTime 要设置的 payTime
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	/**
	 * @return getTime
	 */
	public Date getGetTime() {
		return getTime;
	}
	/**
	 * @param getTime 要设置的 getTime
	 */
	public void setGetTime(Date getTime) {
		this.getTime = getTime;
	}
	
	
}
