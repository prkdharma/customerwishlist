package com.dxctraining.bootmvcjpa.wishlistmgt.dto;

public class CreateWishedItemRequest {
	
	private int custId;

    private String prodId;
    
    public CreateWishedItemRequest() {
    	
    }
    
    public CreateWishedItemRequest(int custId, String prodId) {
    	this.custId = custId;
    	this.prodId = prodId;
    }

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProductId(String prodId) {
		this.prodId = prodId;
	}
	
}