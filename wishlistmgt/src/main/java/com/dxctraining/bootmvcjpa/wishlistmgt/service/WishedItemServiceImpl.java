package com.dxctraining.bootmvcjpa.wishlistmgt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.bootmvcjpa.wishlistmgt.exceptions.InvalidArgumentException;
import com.dxctraining.bootmvcjpa.wishlistmgt.dao.IWishedItemDao;
import com.dxctraining.bootmvcjpa.wishlistmgt.entities.WishedItem;

import java.util.List;
import java.util.Random;

@Transactional
@Service
public class WishedItemServiceImpl implements IWishedItemService{

    @Autowired
    private IWishedItemDao dao;
    
    @Override
    public WishedItem save(WishedItem wishedItem) {
        validate(wishedItem);
    	String id = generateId();
    	wishedItem.setId(id);
        wishedItem=dao.save(wishedItem);
        return wishedItem;
    }

    private String generateId() {
    	StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randNum = random.nextInt(21);
            builder.append(randNum);
        }
        String id = builder.toString();
		return id;
	}

	private void validate(WishedItem wishedItem)
	{
		if(wishedItem == null) 
		{
			throw new InvalidArgumentException("wishedItem can't not be null");
		}
		
	}


    @Override
    public List<WishedItem> allWishedItems(){
        List<WishedItem>list = dao.findAll();
        return list;
    }

	@Override
	public List<WishedItem> findAllById(int custId) {
		validateId(custId);
		List<WishedItem>list = dao.findAllById(custId);
		return list;
	}
	
	private void validateId(int custId) {
		if(custId == 0) {
			throw new InvalidArgumentException("id should not be null");
		}
		
	}

}