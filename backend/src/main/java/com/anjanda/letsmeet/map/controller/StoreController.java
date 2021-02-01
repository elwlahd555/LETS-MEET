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
	public List<Store> mapInDong(String dong) {
		try {
			System.out.println("dong값 받아오기");
			System.out.println("data size : " + StoreService.getStoreInDong(dong).size());
			System.out.println("data size : " + StoreService.getStoreInDong(dong).get(0).getsDong());
			
			return StoreService.getStoreInDong(dong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@ApiOperation(value="좌표로 조회", notes="좌표를 이용해서 조회")
	@GetMapping("/point")
	public Store mapInPoint(double lat, double lng) {
		try {
			System.out.println("좌표값 받아오기");
			System.out.println("data name : " + StoreService.getStoreInPoint(lat,lng).getsName());
			
			return StoreService.getStoreInPoint(lat,lng);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@ApiOperation(value="중간 좌표로 조회", notes="중간 좌표를 이용해서 조회")
	@GetMapping("/midpoint")
	public List<Store> mapInMidpoint(double lat, double lng) {
		try {
			System.out.println("중간 좌표값 받아오기");
			System.out.println("data size : " + StoreService.getStoreInMidpoint(lat,lng).size());
			System.out.println("data size : " + StoreService.getStoreInMidpoint(lat,lng).get(0).getsName());

			return StoreService.getStoreInMidpoint(lat,lng);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
