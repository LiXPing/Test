package cn.tedu.store.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.ex.InsertDataException;

@Service("addressService")
public class AddressServiceImpl implements IAddressService{

	@Autowired 
	private AddressMapper addressMapper;
	

	public Address add(String username, Address address) throws InsertDataException  {
		// 检查address中的uid和recvName是否为null
		// 封装日志信息
		Date now = new Date();
		address.setCreatedUser(username);
		address.setModifiedUser(username);
		address.setCreatedTime(now);
		address.setModifiedTime(now);
		// 执行增加
		Integer rows = addressMapper.insert(address);
		// 判断持久层操作的返回值
		if (rows == 1) {
			// 增加成功，返回
			return address;
		} else {
			// 增加出错，抛出异常
			throw new InsertDataException("增加收货地址信息失败！" + address);
		}
	}

}
