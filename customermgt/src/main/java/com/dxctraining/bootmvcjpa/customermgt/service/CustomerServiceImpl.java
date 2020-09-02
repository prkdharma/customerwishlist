package com.dxctraining.bootmvcjpa.customermgt.service;

import com.dxctraining.bootmvcjpa.customermgt.dao.ICustomerDao;
import com.dxctraining.bootmvcjpa.customermgt.entities.Customer;
import com.dxctraining.bootmvcjpa.customermgt.exceptions.CustomerNotFoundException;
import com.dxctraining.bootmvcjpa.customermgt.exceptions.InvalidArgumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerDao dao;


    @Override
    public Customer save(Customer customer) 
    {  Customer custome=validate(customer);
       custome= dao.save(custome);
       return custome;
    }

    public Customer validate(Customer customer) 
    {
		if(customer==null)
		{
			throw new InvalidArgumentException("customer can't be null");
		}
		return customer;
	}

	
    public Customer findCustomerById(int id) {
      Optional<Customer>optional= dao.findById(id);
      boolean exist=optional.isPresent();
      if(!exist){
          throw new CustomerNotFoundException("customer not found for id="+id);
      }
      Customer customer=optional.get();
       return customer;
    }

    @Override
    public List<Customer>findByName(String name){
        List<Customer>list=dao.findByName(name);
        return list;
    }
}
