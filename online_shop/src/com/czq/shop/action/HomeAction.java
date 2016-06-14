package com.czq.shop.action;

import com.czq.shop.BaseAction;
import com.czq.shop.service.ProductService;

public class HomeAction extends BaseAction{
	private ProductService productService;						//商品Service
	
	public String homeftlPage(){
		return SUCCESS;
	}

	
	
	
	/**
	 * @param productService the productService to set
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * @return the productService
	 */
	public ProductService getProductService() {
		return productService;
	}
}
