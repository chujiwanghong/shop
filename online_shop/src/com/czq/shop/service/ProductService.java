package com.czq.shop.service;

import java.util.List;

import com.czq.shop.dao.ProductDao;
import com.czq.shop.model.CategoryModel;
import com.czq.shop.model.EvaluateModel;
import com.czq.shop.model.OrderFormModel;
import com.czq.shop.model.ProductModel;
import com.czq.shop.model.ProductSearchModel;



public class ProductService {
	private ProductDao productDao;
	
	@SuppressWarnings("unchecked")
	public List<ProductModel> queryProductById(ProductSearchModel productSearch)
	{
		List list = productDao.queryProductById(productSearch);
		return list;
	}
	
	public void updateSaleById(ProductModel producModel){
		productDao.updateSaleById(producModel);
	}
	
	
	public int findBigProductId()
	{
		int tem = productDao.findBigProductId();
		return tem;
	}
	
	
	public List<ProductModel> queryHotProductById(ProductSearchModel productSearch)
	{
		List list = productDao.queryHotProductById(productSearch);
		return list;
	}
	
	public List<CategoryModel> queryCategoryById(ProductSearchModel productSearch)
	{
		List list = productDao.queryCategoryById(productSearch);
		return list;
	}
	
	public boolean insertProduct(ProductModel productModel){
		return productDao.insertProduct(productModel);
	}
	
	public boolean insertEvaluate(EvaluateModel evaluateModel){
		return productDao.insertEvaluate(evaluateModel);
	}
	
	public List<EvaluateModel> queryDescribeByProductId(ProductSearchModel productSearch)
	{
		List list = productDao.queryDescribeByProductId(productSearch);
		return list;
	}

	/**
	 * @return the productDao
	 */
	public ProductDao getProductDao() {
		return productDao;
	}

	/**
	 * @param productDao the productDao to set
	 */
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
}
