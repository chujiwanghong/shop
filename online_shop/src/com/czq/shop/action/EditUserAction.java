package com.czq.shop.action;


import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.czq.shop.BaseAction;
import com.czq.shop.model.EditUser;
import com.czq.shop.service.UserService;

public class EditUserAction extends BaseAction{

	private UserService userService;
	private Object result;
	private List<EditUser> userList;
	private EditUser userStr;
	private String userName;
	private String passWord;
	private String userPhone;
	private String QQ;
	private String nickName;
	private String reservedInformation;
	private String addressInfo;
	private String editedUserName;
	public EditUserAction(){
		if(userStr==null){
			userStr=new EditUser();
		}
	}
	public String editUserftlPage(){
		return SUCCESS;
	}
	
	//添加用户
	public String editUserjsonAddUser(){
		userStr.setUserName(userName);
		userStr.setPassWord(passWord);
		userStr.setNickName(nickName);
		userStr.setQQ(Long.parseLong(QQ));
		userStr.setUserAddress(addressInfo);
		userStr.setUserPhone(Long.parseLong(userPhone));
		userStr.setReservedInformation(reservedInformation);
		userService.insertUserInfo(userStr);
		return SUCCESS;
	}
	
	//查询用户
	public String queryByUserName() throws Exception {
		userList = userService.queryByUserName(userName);
		if(userList.size()==0){
			System.out.println("没有用户！");
		}
		else{
			for(int i=0;i<userList.size();i++){
				String st=userList.get(i).getPageCategory();
				String stchar[]=st.split(":");
				int index[];
				index=new int[stchar.length];
				for(int j=0;j<stchar.length;j++){
					index[j]=Integer.parseInt(stchar[j].toString());
				}
				userList.get(i).setPageId(index);
			}
			JSONArray array = JSONArray.fromObject(userList);	
			DateFormat  dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(Object obj:userList){
		        System.out.println(((EditUser)obj).getId()+((EditUser)obj).getUserName()+dateFormat.format(((EditUser)obj).getCreatDate()));
			}	
			result=array;
		}
		return "success";
	}
	
	//更新
	public String editUserjsonId(){
		userList = userService.queryByUserName(userName);
		if(userList.size()==0){
			System.out.println("没有用户！");
		}
		else{
			JSONArray array =new JSONArray();
			for(int i=0;i<userList.size();i++){
				String st=userList.get(i).getPageCategory();
				String stchar[]=st.split(":");
				int index[];
				index=new int[stchar.length];
				for(int j=0;j<stchar.length;j++){
					index[j]=Integer.parseInt(stchar[j].toString());
					JSONObject obj=new JSONObject();
					obj.accumulate("category", index[j]);
					array.add(obj);
				}
				userList.get(i).setPageId(index);	
			}
			
			result=array;
		}
		return SUCCESS;
	}
	
	
	

	/**
	 * @return userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService 要设置的 userService
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @return result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result 要设置的 result
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * @return userList
	 */
	public List<EditUser> getUserList() {
		return userList;
	}

	/**
	 * @param userList 要设置的 userList
	 */
	public void setUserList(List<EditUser> userList) {
		this.userList = userList;
	}

	/**
	 * @return userStr
	 */
	public EditUser getUserStr() {
		return userStr;
	}

	/**
	 * @param userStr 要设置的 userStr
	 */
	public void setUserStr(EditUser userStr) {
		this.userStr = userStr;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName 要设置的 userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return passWord
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * @param passWord 要设置的 passWord
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/**
	 * @return userPhone
	 */
	public String getUserPhone() {
		return userPhone;
	}

	/**
	 * @param userPhone 要设置的 userPhone
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	/**
	 * @return qQ
	 */
	public String getQQ() {
		return QQ;
	}

	/**
	 * @param qQ 要设置的 qQ
	 */
	public void setQQ(String qQ) {
		QQ = qQ;
	}

	/**
	 * @return reservedInformation
	 */
	public String getReservedInformation() {
		return reservedInformation;
	}

	/**
	 * @param reservedInformation 要设置的 reservedInformation
	 */
	public void setReservedInformation(String reservedInformation) {
		this.reservedInformation = reservedInformation;
	}

	/**
	 * @return addressInfo
	 */
	public String getAddressInfo() {
		return addressInfo;
	}

	/**
	 * @param addressInfo 要设置的 addressInfo
	 */
	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}

	/**
	 * @return editedUserName
	 */
	public String getEditedUserName() {
		return editedUserName;
	}

	/**
	 * @param editedUserName 要设置的 editedUserName
	 */
	public void setEditedUserName(String editedUserName) {
		this.editedUserName = editedUserName;
	}

	/**
	 * @return nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName 要设置的 nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
