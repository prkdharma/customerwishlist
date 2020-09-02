package com.dxctraining.bootmvcjpa.customermgt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.bootmvcjpa.customermgt.dto.CreateCustomerRequest;
import com.dxctraining.bootmvcjpa.customermgt.dto.CustomerDto;
import com.dxctraining.bootmvcjpa.customermgt.entities.Customer;
import com.dxctraining.bootmvcjpa.customermgt.service.ICustomerService;
import com.dxctraining.bootmvcjpa.customermgt.util.CustomerUtil;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	
	@Autowired
	private CustomerUtil CustomerUtil;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDto addCustomer(@RequestBody CreateCustomerRequest requestData) {
		Customer customer = new Customer(requestData.getName());
		customer = service.save(customer);
		CustomerDto response = CustomerUtil.CustomerDto(customer);
		return response;
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDto findCustomerById(@PathVariable("id")int id) {
		Customer customer = service.findCustomerById(id);
		CustomerDto response = CustomerUtil.CustomerDto(customer);
		return response;
	}
    
	@GetMapping("/get/customer/{name}")
	@ResponseStatus(HttpStatus.OK)
	public List<CustomerDto> findCustomerByName(@PathVariable("name")String name) 
	{   
		List<CustomerDto> toreturn=new ArrayList<>();
		List<Customer>list = service.findByName(name);
		for(Customer variable:list)
		{	
		CustomerDto response = CustomerUtil.CustomerDto(variable);
		toreturn.add(response);
		}
		return toreturn;
	}
	

}