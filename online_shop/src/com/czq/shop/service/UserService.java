package com.czq.shop.service;

import java.util.List;

import com.czq.shop.model.EditUser;

public abstract class UserService {

	public abstract List<EditUser> queryByUserName(String userName);
	public abstract  boolean updateUserInfo(EditUser e);
	public abstract void insertUserInfo(EditUser e);
	public abstract void deleteUserInfo(String Password);
}
