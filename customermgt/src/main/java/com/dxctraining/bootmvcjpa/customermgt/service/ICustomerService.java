package com.dxctraining.bootmvcjpa.customermgt.service;

import java.util.List;

import com.dxctraining.bootmvcjpa.customermgt.entities.Customer;

public interface ICustomerService {

    Customer save(Customer customer);

    Customer findCustomerById(int id);

    List<Customer>findByName(String name);
    
    

}
