package com.czq.shop.dao;

import java.sql.SQLException;
import java.util.List;

import com.czq.shop.model.AddressInfo;
import com.czq.shop.model.CategoryModel;
import com.czq.shop.model.EvaluateModel;
import com.czq.shop.model.ProductModel;
import com.czq.shop.model.ProductSearchModel;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ProductDao {
	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	@SuppressWarnings("unchecked")
	public List<CategoryModel> queryCategoryById(ProductSearchModel productSearch){
		List list = null;
		try {
			list = (List)sqlMapClient.queryForList("queryCategoryById",productSearch);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateSaleById(ProductModel productModel){
		try {
			sqlMapClient.update("updateSaleById", productModel);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public int findBigProductId(){
		List<ProductModel> list = null;
		try {
			list=(List)sqlMapClient.queryForList("findBigProductId");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int num=10000;
		if(list!=null){
			num=(int)(list.get(0).getProductId());
		}
		
		return num;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductModel> queryHotProductById(ProductSearchModel productSearch){
		List list = null;
		try {
			list = (List)sqlMapClient.queryForList("queryHotProductById",productSearch);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductModel> queryProductById(ProductSearchModel productSearch){
		List list = null;
		try {
			list = (List)sqlMapClient.queryForList("queryProductById",productSearch);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<EvaluateModel> queryDescribeByProductId(ProductSearchModel productSearch){
		List list = null;
		try {
			list = (List)sqlMapClient.queryForList("queryDescribeByProductId",productSearch);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean insertEvaluate(EvaluateModel evaluateModel){
		boolean b;
		try {
			sqlMapClient.insert("insertEvaluate", evaluateModel);
			b = true;
		} catch (SQLException e) {
			e.printStackTrace();
			b = false;
		}
		return b ;
	}
	
	public boolean insertProduct(ProductModel productModel){
		boolean b;
		try {
			sqlMapClient.insert("insertProduct", productModel);
			b = true;
		} catch (SQLException e) {
			e.printStackTrace();
			b = false;
		}
		return b ;
	}
}