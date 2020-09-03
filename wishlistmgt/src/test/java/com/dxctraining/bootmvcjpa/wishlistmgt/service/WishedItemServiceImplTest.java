package com.dxctraining.bootmvcjpa.wishlistmgt.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.dxctraining.bootmvcjpa.wishlistmgt.entities.WishedItem;
import com.dxctraining.bootmvcjpa.wishlistmgt.exceptions.InvalidArgumentException;

import org.junit.jupiter.api.function.Executable;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(WishedItemServiceImpl.class)
class WishedItemServiceImplTest {
	
	@Autowired
	private IWishedItemService service;
	
	@Test
	public void testAdd_1() {
		Executable execute = () -> service.save(null);
		Assertions.assertThrows(InvalidArgumentException.class, execute);
	}

	@Test
	public void testAdd_2() {
		int custId = 1;
		String prodId = "658";
		WishedItem wishedItem = new WishedItem(custId,prodId);
		wishedItem = service.save(wishedItem);
		List<WishedItem>list = new ArrayList<>();
		list.add(wishedItem);
		WishedItem fetched = list.get(0);
		Assertions.assertEquals(1, list.size());
		Assertions.assertEquals(custId, fetched.getCustId());
		Assertions.assertEquals(prodId, fetched.getProdId());
	}

}