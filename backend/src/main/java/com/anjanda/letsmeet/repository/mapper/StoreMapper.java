package com.anjanda.letsmeet.repository.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anjanda.letsmeet.repository.dto.Store;

public interface StoreMapper {

	public List<Store> getStore(String dong) throws Exception;

}
