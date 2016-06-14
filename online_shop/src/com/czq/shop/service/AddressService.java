package com.czq.shop.service;

import java.util.List;

import com.czq.shop.dao.AddressDao;
import com.czq.shop.model.AddressInfo;


public class AddressService {
	private AddressDao address;
	
	public AddressDao getAddress() {
		return address;
	}

	public void setAddress(AddressDao address) {
		this.address = address;
	}

	@SuppressWarnings("unchecked")
	public List<AddressInfo> findAddressById(int upid)
	{
		List list = address.findAddressById(upid);
		return list;
	}
}
