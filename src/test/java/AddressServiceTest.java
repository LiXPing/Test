import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;

public class AddressServiceTest {

	@Test
	public void insert() {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml");
		
		AddressMapper addressMapper 
			= ac.getBean(
				"addressMapper", 
				AddressMapper.class);
		
		Address address = new Address();
		address.setUid(1);
		address.setRecvName("刘老师");
		Integer rows = addressMapper.insert(address );
		System.out.println("rows=" + rows);
		
		ac.close();
	}
	
}