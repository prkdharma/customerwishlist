package com.dxctraining.bootmvcjpa.customermgt.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dxctraining.bootmvcjpa.customermgt.dto.CustomerDto;
import com.dxctraining.bootmvcjpa.customermgt.entities.Customer;

@Component
public class CustomerUtil {

	public CustomerDto CustomerDto(Customer customer) {
		CustomerDto dto = new CustomerDto(customer.getId(), customer.getName());
		return dto;
	}
    
    
}