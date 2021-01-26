package com.anjanda.letsmeet.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.anjanda.letsmeet.map.service.StoreService;
import com.anjanda.letsmeet.repository.dto.Store;

public class StoreController {

	@Autowired
	StoreService StoreService;
	
	@GetMapping("/dong")
	public List<Store> mapDong(String dong) {
		try {
			System.out.println("dong값 받아오기");
			System.out.println("data size : " + StoreService.getStore(dong).size());
			System.out.println("data size : " + StoreService.getStore(dong).get(0).getsDong());
			
			return StoreService.getStore(dong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
