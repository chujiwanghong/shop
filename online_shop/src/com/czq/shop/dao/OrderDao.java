package com.czq.shop.dao;

import java.sql.SQLException;
import java.util.List;
import com.czq.shop.model.OderProductModel;
import com.czq.shop.model.OrderFormModel;
import com.czq.shop.model.ProductSearchModel;
import com.ibatis.sqlmap.client.SqlMapClient;

public class OrderDao {
	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	@SuppressWarnings("unchecked")
	public List queryOderProductById(ProductSearchModel productSearch){
		List list = null;
		try {
			list = (List)sqlMapClient.queryForList("queryOderProductById",productSearch);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public int findOrderFormId(){
		List<OrderFormModel> list = null;
		try {
			list=(List)sqlMapClient.queryForList("findOrderFormId");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int num=100001;
		if(list!=null){
			num=(int)(list.get(0).getOrderId())+1;
		}
		
		return num;
	}
	
	@SuppressWarnings("unchecked")
	public List queryOrderFormById(ProductSearchModel productSearch){
		List list = null;
		try {
			list = (List)sqlMapClient.queryForList("queryOrderFormById",productSearch);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	
	public boolean insertOderProduct(OderProductModel oderProductModel){
		boolean b;
		try {
			sqlMapClient.insert("insertOderProduct", oderProductModel);
			b = true;
		} catch (SQLException e) {
			e.printStackTrace();
			b = false;
		}
		return b ;
	}
	
	public boolean insertOrderForm(OrderFormModel orderFormModel){
		boolean b;
		try {
			sqlMapClient.insert("insertOrderForm", orderFormModel);
			b = true;
		} catch (SQLException e) {
			e.printStackTrace();
			b = false;
		}
		return b ;
	}
	
	public void updateDeliverTimeById(OrderFormModel orderFormModel){
		try {
			sqlMapClient.update("updateDeliverTimeById", orderFormModel);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateReceiptTimeById(OrderFormModel orderFormModel){
		try {
			sqlMapClient.update("updateReceiptTimeById", orderFormModel);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePayTimeById(OrderFormModel orderFormModel){
		try {
			sqlMapClient.update("updatePayTimeById", orderFormModel);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateGetTimeById(OrderFormModel orderFormModel){
		try {
			sqlMapClient.update("updateGetTimeById", orderFormModel);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}