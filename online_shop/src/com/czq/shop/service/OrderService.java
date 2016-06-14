package com.czq.shop.service;

import java.util.List;

import com.czq.shop.dao.OrderDao;
import com.czq.shop.model.CategoryModel;
import com.czq.shop.model.EvaluateModel;
import com.czq.shop.model.OderProductModel;
import com.czq.shop.model.OrderFormModel;
import com.czq.shop.model.ProductModel;
import com.czq.shop.model.ProductSearchModel;



public class OrderService {
	private OrderDao orderDao;
	
	@SuppressWarnings("unchecked")
	public List<OderProductModel> queryOderProductById(ProductSearchModel productSearch)
	{
		List list = orderDao.queryOderProductById(productSearch);
		return list;
	}
	
	public int findOrderFormId()
	{
		int tem = orderDao.findOrderFormId();
		return tem;
	}
	
	
	public List<OrderFormModel> queryOrderFormById(ProductSearchModel productSearch)
	{
		List list = orderDao.queryOrderFormById(productSearch);
		return list;
	}
	
	
	public boolean insertOderProduct(OderProductModel oderProductModel){
		return orderDao.insertOderProduct(oderProductModel);
	}
	
	public boolean insertOrderForm(OrderFormModel orderFormModel){
		return orderDao.insertOrderForm(orderFormModel);
	}
	
	public void updateDeliverTimeById(OrderFormModel orderFormModel){
		 orderDao.updateDeliverTimeById(orderFormModel);
	}

	public void updateReceiptTimeById(OrderFormModel orderFormModel){
		 orderDao.updateReceiptTimeById(orderFormModel);
	}
	
	public void updatePayTimeById(OrderFormModel orderFormModel){
		 orderDao.updatePayTimeById(orderFormModel);
	}
	
	public void updateGetTimeById(OrderFormModel orderFormModel){
		 orderDao.updateGetTimeById(orderFormModel);
	}
	/**
	 * @return orderDao
	 */
	public OrderDao getOrderDao() {
		return orderDao;
	}

	/**
	 * @param orderDao 要设置的 orderDao
	 */
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	
}
