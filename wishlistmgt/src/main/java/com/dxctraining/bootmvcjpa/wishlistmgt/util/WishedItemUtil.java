package com.dxctraining.bootmvcjpa.wishlistmgt.util;

import org.springframework.stereotype.Component;

import com.dxctraining.bootmvcjpa.wishlistmgt.dto.WishedItemDto;
import com.dxctraining.bootmvcjpa.wishlistmgt.entities.WishedItem;

@Component
public class WishedItemUtil {


    public WishedItemDto wishedItemDto(WishedItem wishedItem, int custId, String custName, String prodId, String prodName){
        WishedItemDto dto=new WishedItemDto(wishedItem.getId());
        dto.setCustId(custId);
        dto.setCustName(custName);
        dto.setProdId(prodId);
        dto.setProdName(prodName);
        return dto;
    }

}