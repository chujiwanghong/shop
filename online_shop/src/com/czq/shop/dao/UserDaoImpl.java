package com.czq.shop.dao;

import java.sql.SQLException;
import java.util.List;

import com.czq.shop.model.EditUser;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UserDaoImpl implements UserDao {
	
	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	@SuppressWarnings("unchecked")
	public List<EditUser> queryByUserName(String userName){
		List list = null;
		try {
			list = (List)sqlMapClient.queryForList("queryByUserName",userName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int deleteUserInfo(String userName) {
		try {
			int i = sqlMapClient.delete("deleteUserInfo", userName);
			if(i>0){
				return i;
			}else{
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}



	public boolean insertUserInfo(EditUser temUser) {
		boolean b;
		try {
			sqlMapClient.insert("insertUserInfo", temUser);
			b = true;
		} catch (SQLException e) {
			e.printStackTrace();
			b = false;
		}
		return b ;
	}

	public boolean updateUserInfo(EditUser temUser) {
		boolean b ;
		try {
			sqlMapClient.update("updateUserInfo", temUser);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}
}
