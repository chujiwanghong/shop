package com.czq.shop.dao;

import java.util.List;

import com.czq.shop.model.EditUser;



public interface UserDao {
	public List<EditUser> queryByUserName(String userName);
}
