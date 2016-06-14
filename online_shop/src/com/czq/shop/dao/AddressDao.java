package com.czq.shop.dao;

import java.sql.SQLException;
import java.util.List;

import com.czq.shop.model.AddressInfo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class AddressDao {
	private SqlMapClient sqlMapClient;		//创建SqlMapClient

	public List<AddressInfo> findAddressById(int upid){  //通过父ID，查询所属城市名称和ID
		List<AddressInfo> list = null;
		try {
			list = sqlMapClient.queryForList("findAddressById",upid);
		} catch (SQLException e) {						 //发生异常，打印堆栈信息
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public SqlMapClient getSqlMapClient() {       //SqlMapClient  get方法
		return sqlMapClient;
	}
	public void setSqlMapClient(SqlMapClient sqlMapClient) {   //SqlMapClient  set方法
		this.sqlMapClient = sqlMapClient;
	}	
}