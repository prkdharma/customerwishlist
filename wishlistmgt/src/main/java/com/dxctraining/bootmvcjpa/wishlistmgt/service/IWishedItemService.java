package com.dxctraining.bootmvcjpa.wishlistmgt.service;

import java.util.List;

import com.dxctraining.bootmvcjpa.wishlistmgt.entities.WishedItem;

public interface IWishedItemService {

    WishedItem save(WishedItem wishedItem);
    
    List<WishedItem> findAllById(int custId);
    
    List<WishedItem> allWishedItems();

}
