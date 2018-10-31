import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ex.InsertDataException;

public class AddressMapperTest {

	@Test
	public void add() throws InsertDataException {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");
		
		IAddressService addressService 
			= ac.getBean(
				"addressService", 
				IAddressService.class);
		
		Address address = new Address();
		address.setUid(1);
		address.setRecvName("刘老师");
		Address result = addressService.add(
				"mybatis", address);
		System.out.println("result=" + result);
		
		ac.close();
	}
	
}