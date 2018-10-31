package cn.tedu.store.service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.InsertDataException;

public interface IAddressService {


	/**
	 * 增加新的收货地址
	 * @param username 当前登录的用户名
	 * @param address 收货地址数据
	 * @return 成功增加的收货地址数据，且包含数据的id
	 * @throws InsertDataException
	 */
	Address add(String username, Address address) throws InsertDataException;
	
	
}
