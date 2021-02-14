package com.anjanda.letsmeet.gallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjanda.letsmeet.gallery.service.GalleryService;
import com.anjanda.letsmeet.repository.dto.Gallery;

@RestController
@RequestMapping("/memory")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	/* C :: 추억 공유 사진 추가 */
	@PostMapping("/add")
	public ResponseEntity<String> addGallery(Gallery gallery) throws Exception {
		System.out.println("사진 경로명 : " + gallery.getgName());
		if(galleryService.insertGallery(gallery) > 0)
			return new ResponseEntity<String>("추억에 사진 추가 성공", HttpStatus.OK);
		return new ResponseEntity<String>("추억에 사진 추가 실패", HttpStatus.NO_CONTENT);
	}
	
	/* R :: 추억 공유 사진 조회 */
	@GetMapping("/detail")
	public ResponseEntity<List<Gallery>> reviewGallery(int gMrNo) throws Exception {
		return new ResponseEntity<List<Gallery>>(galleryService.selectGallery(gMrNo), HttpStatus.OK);
	}
	
	/* U :: 추억 공유 사진 수정 */
	@PutMapping("/edit")
	public ResponseEntity<String> updateGallery(Gallery gallery) throws Exception {
		System.out.println("수정될 사진 번호 " + gallery.getgNo());
		if(galleryService.updateGallery(gallery) > 0)
			return new ResponseEntity<String>("사진 수정 성공", HttpStatus.OK);
		return new ResponseEntity<String>("사진 수정 실패", HttpStatus.NO_CONTENT);
	}
	
	/* D :: 추억 공유 사진 삭제 */
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteGallery(Gallery gallery) throws Exception {
		System.out.println("수정될 사진 번호 : " + gallery.getgNo());
		if(galleryService.deleteGallery(gallery) > 0)
			return new ResponseEntity<String>("추억사진 삭제 성공", HttpStatus.OK);
		return new ResponseEntity<String>("추억사진 삭제 실패", HttpStatus.NO_CONTENT);
	}
}
