package com.czq.shop.service;

import java.util.List;

import com.czq.shop.dao.UserDao;
import com.czq.shop.dao.UserDaoImpl;
import com.czq.shop.model.EditUser;

public class UserServiceImpl extends UserService{

	private UserDaoImpl editUser=null;
	
	
	/**
	 * @return the editUser
	 */
	public UserDaoImpl getEditUser() {
		return editUser;
	}
	public void setEditUser(UserDaoImpl editUser) {
		this.editUser = editUser;
	}
	
	public  boolean updateUserInfo(EditUser e){
		boolean b = editUser.updateUserInfo(e);
		if(b){
			return true;
		}else{
			return false;
		}
	}
	public  void insertUserInfo(EditUser e){
		boolean b = editUser.insertUserInfo(e);
	}
	public  void deleteUserInfo(String userName){
		int i=editUser.deleteUserInfo(userName);
	}
	

	public List<EditUser> queryByUserName(String userName)
	{
		List list = editUser.queryByUserName(userName);
		return list;
	}

	
}
