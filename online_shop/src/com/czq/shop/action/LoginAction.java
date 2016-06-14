package com.czq.shop.action;

import java.util.List;
import com.czq.shop.BaseAction;
import com.czq.shop.model.EditUser;
import com.czq.shop.service.UserService;
import net.sf.json.JSONArray;


public class LoginAction extends BaseAction{
	private UserService userService;				//操作用户数据库类
	private Object result;							//json回传结果集
	private List<EditUser> userList;				//操作用户数据表结果集
	private EditUser userStr;						//用户model
	private String userName;
	private String passWord;
	
	
	
	LoginAction(){
		if(userStr==null){
			userStr=new EditUser();
		}
	}
	
	//返回登录页面
	public String loginftlPage(){
		userStr=new EditUser();
		return SUCCESS;
	}
	
	//校验用户是否存在
	public String loginjsonUserchange(){
		userList = userService.queryByUserName(userName);
		if(userList.size()!=0)
		{
			JSONArray array = JSONArray.fromObject(userList);
			result=array;
		}
		return SUCCESS;
	}
	
	//校验用户登录信息
	public String loginjsonSys(){
		userList = userService.queryByUserName(userName);
		userStr=userList.get(0);
		if(userStr.getUserName().equals(userName)&&userStr.getPassWord().equals(passWord)){
			JSONArray array = JSONArray.fromObject(userList);
			result=array;
		}
		return SUCCESS;
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * @return the userList
	 */
	public List<EditUser> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<EditUser> userList) {
		this.userList = userList;
	}

	/**
	 * @return the userStr
	 */
	public EditUser getUserStr() {
		return userStr;
	}

	/**
	 * @param userStr the userStr to set
	 */
	public void setUserStr(EditUser userStr) {
		this.userStr = userStr;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}


