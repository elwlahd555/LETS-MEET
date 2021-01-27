package com.anjanda.letsmeet.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjanda.letsmeet.map.service.StoreService;
import com.anjanda.letsmeet.repository.dto.Store;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/map")
public class StoreController {

	@Autowired
	private StoreService StoreService;
	
	@ApiOperation(value="전체 동 조회", notes="동을 이용해서 조회")
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
