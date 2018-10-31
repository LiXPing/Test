package cn.tedu.store.mapper;

import cn.tedu.store.entity.Address;

public interface AddressMapper {

	/**
	 * 新增收货地址
	 * @param address 收货地址数据
	 * @return 受影响的行数
	 */
	Integer insert(Address address);
	
}