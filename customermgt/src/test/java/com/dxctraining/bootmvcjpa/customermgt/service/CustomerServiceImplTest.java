package com.dxctraining.bootmvcjpa.customermgt.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.function.Executable;

import com.dxctraining.bootmvcjpa.customermgt.entities.Customer;
import com.dxctraining.bootmvcjpa.customermgt.exceptions.InvalidArgumentException;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(CustomerServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerServiceImplTest {
	@Autowired
	ICustomerService service;

	@Test
	public void testAdd_1() {
		Executable execute = () -> service.save(null);
		Assertions.assertThrows(InvalidArgumentException.class, execute);
	}

	@Test
	public void testAdd_2() {
		String name = "gayathri";
		Customer customer = new Customer(name);
		customer = service.save(customer);
		Customer fetched = service.findCustomerById(customer.getId());
		Assertions.assertEquals(customer.getId(), fetched.getId());
		Assertions.assertEquals(name, fetched.getName());
	}

}
