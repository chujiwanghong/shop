package com.czq.shop.action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.ListIterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.czq.shop.BaseAction;
import com.czq.shop.model.AddressInfo;
import com.czq.shop.service.AddressService;

public class AddressAction extends BaseAction {
	private AddressService addressService=null;
	private String upId;
	private Object result = null;
	
	public String addressftlPage(){
		return SUCCESS;
	}
	
	public String searchAddress() throws Exception {
		try{
			setUpId(java.net.URLDecoder.decode(upId,"UTF-8").trim());
		}catch (UnsupportedEncodingException e) {
		}
		List<AddressInfo> address = addressService.findAddressById(Integer.parseInt(upId));
		AddressInfo temUser = new AddressInfo();
		JSONObject temObject = new JSONObject();
		JSONArray array =new JSONArray(); 
		ListIterator iterator = address.listIterator();
		while(iterator.hasNext())
		{
			temUser=(AddressInfo) iterator.next();
			temObject.accumulate("value", temUser.getId());
			temObject.accumulate("name", temUser.getName());
			array.add(temObject);
			temObject.clear();
		}		
		result = array;
		return SUCCESS;
	}
	public AddressService getAddressService() {
		return addressService;
	}
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	public String getUpId() {
		return upId;
	}
	public void setUpId(String upId) {
		this.upId = upId;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
}
