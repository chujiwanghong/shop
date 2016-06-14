package com.czq.shop.model;

import java.util.Date;

public class EvaluateModel {
	private long productId;    				//产品ID
	private int describeId;	   				//描述ID
	private String merchantName;			//商家名称
	private String describeUser;			//描述人
	private int describeType; 				//描述类型 1：详细描述  2：评价
	private String describeCharacter; 		//描述文字
	private String describePicture; 		//描述图片URL
	Date updateTime;						//更新时间
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
	 * @return 描述ID
	 */
	public int getDescribeId() {
		return describeId;
	}
	/**
	 * @param 描述ID
	 */
	public void setDescribeId(int describeId) {
		this.describeId = describeId;
	}
	/**
	 * @return 描述类型 1：详细描述  2：评价
	 */
	public int getDescribeType() {
		return describeType;
	}
	/**
	 * @param 描述类型 1：详细描述  2：评价
	 */
	public void setDescribeType(int describeType) {
		this.describeType = describeType;
	}
	/**
	 * @return 描述文字
	 */
	public String getDescribeCharacter() {
		return describeCharacter;
	}
	/**
	 * @param 描述文字
	 */
	public void setDescribeCharacter(String describeCharacter) {
		this.describeCharacter = describeCharacter;
	}
	/**
	 * @return 描述图片URL
	 */
	public String getDescribePicture() {
		return describePicture;
	}
	/**
	 * @param 描述图片URL
	 */
	public void setDescribePicture(String describePicture) {
		this.describePicture = describePicture;
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
	 * @param merchantName the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	/**
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}
	/**
	 * @return the describeUser
	 */
	public String getDescribeUser() {
		return describeUser;
	}
	/**
	 * @param describeUser the describeUser to set
	 */
	public void setDescribeUser(String describeUser) {
		this.describeUser = describeUser;
	}
	
}
