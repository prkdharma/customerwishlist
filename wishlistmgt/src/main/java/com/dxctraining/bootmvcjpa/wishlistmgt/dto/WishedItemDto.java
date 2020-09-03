package com.dxctraining.bootmvcjpa.wishlistmgt.dto;

public class WishedItemDto {

    private String id;

    private int custId;
    
    private String prodId;
    
    private String custName;
    
    private String prodName;

    public WishedItemDto(){

    }

    public WishedItemDto(String id){
        this.id=id;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

}