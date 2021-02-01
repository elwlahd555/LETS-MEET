package com.anjanda.letsmeet.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.anjanda.letsmeet.repository.dto.Store;
import com.anjanda.letsmeet.repository.mapper.StoreMapper;

public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreMapper mapper;
	
	@Override
	public List<Store> getStore(String dong) {
		return mapper.getStore(dong);
	}

}
