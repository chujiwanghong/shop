package com.czq.shop.model;

import java.util.Date;

public class CategoryModel {
	private int categoryId;  		 //主题ID
	private String categoryEn; 		 //主题英文名
	private String categoryName;  	 //主题名称
	private Date updateTime;		 //更新时间
	private int categoryProduct1;	 //主题产品1
	private int categoryProduct2;	 //主题产品2
	private int categoryProduct3;	 //主题产品3
	private int categoryProduct4;	 //主题产品4
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the categoryEn
	 */
	public String getCategoryEn() {
		return categoryEn;
	}
	/**
	 * @param categoryEn the categoryEn to set
	 */
	public void setCategoryEn(String categoryEn) {
		this.categoryEn = categoryEn;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	 * @return the categoryProduct1
	 */
	public int getCategoryProduct1() {
		return categoryProduct1;
	}
	/**
	 * @param categoryProduct1 the categoryProduct1 to set
	 */
	public void setCategoryProduct1(int categoryProduct1) {
		this.categoryProduct1 = categoryProduct1;
	}
	/**
	 * @return the categoryProduct2
	 */
	public int getCategoryProduct2() {
		return categoryProduct2;
	}
	/**
	 * @param categoryProduct2 the categoryProduct2 to set
	 */
	public void setCategoryProduct2(int categoryProduct2) {
		this.categoryProduct2 = categoryProduct2;
	}
	/**
	 * @return the categoryProduct3
	 */
	public int getCategoryProduct3() {
		return categoryProduct3;
	}
	/**
	 * @param categoryProduct3 the categoryProduct3 to set
	 */
	public void setCategoryProduct3(int categoryProduct3) {
		this.categoryProduct3 = categoryProduct3;
	}
	/**
	 * @return the categoryProduct4
	 */
	public int getCategoryProduct4() {
		return categoryProduct4;
	}
	/**
	 * @param categoryProduct4 the categoryProduct4 to set
	 */
	public void setCategoryProduct4(int categoryProduct4) {
		this.categoryProduct4 = categoryProduct4;
	}
}
