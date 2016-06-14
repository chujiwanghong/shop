package com.czq.shop.model;

import java.io.Serializable;
import java.util.Date;

public class EditUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;								//用户ID
	private String userName;						//用户名
	private String passWord;						//密码
	private String nickName;						//用户昵称
	private int userType;							//用户类型  0.超级用户、1.普通用户、 2.商家
	private Date creatDate;							//创建时间
	private String userAddress;						//用户地址
	private long userPhone;							//手机号
	private String pageCategory;					//主页类目ID字符串
	private long QQ;								//QQ号
	private String reservedInformation;				//预留信息
	private int pageId[];							//主页类目ID数组
	//默认构造函数
	public EditUser(){}  
	
	//带用户名和密码的构造函数
	public EditUser(String userName,String passWord){
		this.userName=userName;
		this.passWord=passWord;
	} 
	
	
	//自动创建get和set方法
	
	/**
	 * @return the userType
	 */
	public int getUserType() {
		return userType;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(int userType) {
		this.userType = userType;
	}
	/**
	 * @return the creatDate
	 */
	public Date getCreatDate() {
		return creatDate;
	}
	/**
	 * @param creatDate the creatDate to set
	 */
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}
	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	/**
	 * @return the userPhone
	 */
	public long getUserPhone() {
		return userPhone;
	}
	/**
	 * @param userPhone the userPhone to set
	 */
	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}
	/**
	 * @return the qQ
	 */
	public long getQQ() {
		return QQ;
	}
	/**
	 * @param qQ the qQ to set
	 */
	public void setQQ(long qQ) {
		QQ = qQ;
	}
	/**
	 * @return the reservedInformation
	 */
	public String getReservedInformation() {
		return reservedInformation;
	}
	/**
	 * @param reservedInformation the reservedInformation to set
	 */
	public void setReservedInformation(String reservedInformation) {
		this.reservedInformation = reservedInformation;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @param pagecategory the pagecategory to set
	 */
	public void setPageCategory(String pageCategory) {
		this.pageCategory = pageCategory;
	}

	/**
	 * @return the pagecategory
	 */
	public String getPageCategory() {
		return pageCategory;
	}

	/**
	 * @param pageId the pageId to set
	 */
	public void setPageId(int pageId[]) {
		this.pageId = pageId;
	}

	/**
	 * @return the pageId
	 */
	public int[] getPageId() {
		return pageId;
	}

}
