package com.czq.shop.model;

import java.util.Date;
import java.util.List;

public class ProductModel {
	private long productId;				//产品ID
	private String productName;			//产品名称
	private String merchantName;		//商家名称
	private String productType;			//所属类目
	private double productPrice;		//产品价格
	private double discountPrice;		//促销价格
	private String indexPictuer;		//主页图片URL
	private int inventoryNum;			//库存数量
	private int saleNum;				//卖出数量
	private String simpleDescribe;		//简单描述
	List<EvaluateModel> evaluate;		//产品描述
	Date updateTime;					//更新时间
	/**
	 * @return 产品ID
	 */
	public long getProductId() {
		return productId;
	}
	/**
	 * @param 产品ID
	 */
	
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	/**
	 * @return 产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param 产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return 所属类目
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * @param 所属类目
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	/**
	 * @return 产品价格
	 */
	public double getProductPrice() {
		return productPrice;
	}
	/**
	 * @param 产品价格
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * @return 促销价格
	 */
	public double getDiscountPrice() {
		return discountPrice;
	}
	/**
	 * @param 促销价格
	 */
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	/**
	 * @return 主页图片URL
	 */
	public String getIndexPictuer() {
		return indexPictuer;
	}
	/**
	 * @param 主页图片URL
	 */
	public void setIndexPictuer(String indexPictuer) {
		this.indexPictuer = indexPictuer;
	}
	/**
	 * @return 库存数量
	 */
	public int getInventoryNum() {
		return inventoryNum;
	}
	/**
	 * @param 库存数量
	 */
	public void setInventoryNum(int inventoryNum) {
		this.inventoryNum = inventoryNum;
	}
	/**
	 * @return 卖出数量
	 */
	public int getSaleNum() {
		return saleNum;
	}
	/**
	 * @param 卖出数量
	 */
	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}
	/**
	 * @return 简单描述
	 */
	public String getSimpleDescribe() {
		return simpleDescribe;
	}
	/**
	 * @param 简单描述
	 */
	public void setSimpleDescribe(String simpleDescribe) {
		this.simpleDescribe = simpleDescribe;
	}
	/**
	 * @return 产品描述
	 */
	public List<EvaluateModel> getEvaluate() {
		return evaluate;
	}
	/**
	 * @param 产品描述
	 */
	public void setEvaluate(List<EvaluateModel> evaluate) {
		this.evaluate = evaluate;
	}
	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}
	/**
	 * @param merchantName the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	
}
