package com.czq.shop.model;

public class AddressInfo {
	private String name;		//行政区域名称
	private int id;       		//自己ID，用于查找下级行政区域
	private int upId; 		//从属ID用于查找上级行政区域
	private int level; 			//0：国家；1：省；2：市；3：区；
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUpId() {
		return upId;
	}
	public void setUpId(int upId) {
		this.upId = upId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
