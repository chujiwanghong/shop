package com.czq.shop;

public class CityInfo {
	private String cityName=null;
	private String province=null;
	private String city=null;
	
	CityInfo(){}
	
	public CityInfo(String province,String city,String cityName)
	{
		this.cityName=cityName;
		this.city=city;
		this.province=province;
	}
	
	public void add(String province,String city,String cityName)
	{
		this.cityName=cityName;
		this.city=city;
		this.province=province;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
