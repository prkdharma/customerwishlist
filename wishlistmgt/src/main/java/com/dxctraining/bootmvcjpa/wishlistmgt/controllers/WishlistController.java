package com.dxctraining.bootmvcjpa.wishlistmgt.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.bootmvcjpa.wishlistmgt.dto.CreateWishedItemRequest;
import com.dxctraining.bootmvcjpa.wishlistmgt.dto.CustomerDto;
import com.dxctraining.bootmvcjpa.wishlistmgt.dto.ProductDto;
import com.dxctraining.bootmvcjpa.wishlistmgt.dto.WishedItemDto;
import com.dxctraining.bootmvcjpa.wishlistmgt.entities.WishedItem;
import com.dxctraining.bootmvcjpa.wishlistmgt.service.IWishedItemService;
import com.dxctraining.bootmvcjpa.wishlistmgt.util.WishedItemUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private IWishedItemService service;

    @Autowired
    private WishedItemUtil wishedItemUtil;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public WishedItemDto addWishlist(@RequestBody CreateWishedItemRequest requestData) {
		WishedItem wishedItem = new WishedItem(requestData.getCustId(), requestData.getProdId());
		wishedItem = service.save(wishedItem);
		CustomerDto customerDto = findCustomerDetailsByCustId(requestData.getCustId());
		customerDto.setCustId(requestData.getCustId());
		ProductDto productDto = findProductDetailsByProdId(requestData.getProdId());
		WishedItemDto response = wishedItemUtil.wishedItemDto(wishedItem,customerDto.getCustId(),customerDto.getName(),productDto.getId(),productDto.getName());
		return response;
	}
    
    @GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<WishedItemDto> findAllWishedItemsById(@PathVariable("id")int custId) {
		List<WishedItem>list = service.findAllById(custId);
		List<WishedItemDto>response = new ArrayList<>();
		for(WishedItem wishedItem:list) {
			String prodId = wishedItem.getProdId();
        	ProductDto productDto = findProductDetailsByProdId(prodId);
        	int customerId = wishedItem.getCustId();
        	CustomerDto customerDto = findCustomerDetailsByCustId(customerId);
			WishedItemDto dto = wishedItemUtil.wishedItemDto(wishedItem,customerId,customerDto.getName(),prodId, productDto.getName());
			response.add(dto);
		}
		return response;
	}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WishedItemDto> fetchAll() {
        List<WishedItem> list = service.allWishedItems();
        List<WishedItemDto>response=new ArrayList<>();
        for (WishedItem wishedItem:list){
        	String prodId = wishedItem.getProdId();
        	ProductDto productDto = findProductDetailsByProdId(prodId);
        	int custId = wishedItem.getCustId();
        	CustomerDto customerDto = findCustomerDetailsByCustId(custId);
            WishedItemDto dto=wishedItemUtil.wishedItemDto(wishedItem,custId,customerDto.getName(),prodId, productDto.getName());
            response.add(dto);
        }
        return response;
    }
    
    public CustomerDto findCustomerDetailsByCustId(int custId) {
    	String url = "http://localhost:8585/customers/get/"+custId;
    	CustomerDto dto = restTemplate.getForObject(url, CustomerDto.class);
		return dto;
    }
    
    public ProductDto findProductDetailsByProdId(String prodId) {
    	String url = "http://localhost:8586/products/get/"+prodId;
    	ProductDto dto = restTemplate.getForObject(url, ProductDto.class);
		return dto;
    }

}
