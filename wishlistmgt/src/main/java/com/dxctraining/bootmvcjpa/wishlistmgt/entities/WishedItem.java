package com.dxctraining.bootmvcjpa.wishlistmgt.entities;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class WishedItem {

    @Id
    private String id;

    private int custId;
    
    private String prodId;
    
    public WishedItem() {

    }

    public WishedItem(int custId, String prodId) {
         this.custId = custId;
         this.prodId = prodId;
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

	public void setProductId(String prodId) {
		this.prodId = prodId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WishedItem wishedItem = (WishedItem) o;
        return Objects.equals(id, wishedItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}