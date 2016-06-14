package com.czq.shop.model;

public class ProductSearchModel {
	private String userName;    //用户名
	private long productId;		//产品ID
	private int describeid;		//描述ID
	private String merchant;    //商家名
	private String productName; //商品名
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}
	/**
	 * @param temProductId the productId to set
	 */
	public void setProductId(long temProductId) {
		this.productId = temProductId;
	}
	/**
	 * @param describeid the describeid to set
	 */
	public void setDescribeid(int describeid) {
		this.describeid = describeid;
	}
	/**
	 * @return the describeid
	 */
	public int getDescribeid() {
		return describeid;
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
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName 要设置的 productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
