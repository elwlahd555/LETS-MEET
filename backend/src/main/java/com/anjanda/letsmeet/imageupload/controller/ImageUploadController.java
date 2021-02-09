package com.anjanda.letsmeet.imageupload.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.anjanda.letsmeet.imageupload.service.ImageUploadService;
import com.anjanda.letsmeet.repository.dto.Image;

/**
 * 
 * @Date : 2021. 2. 8.
 * @Team : AnJanDa
 * @author : 김동빈
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : 이미지 업로드 관련 컨트롤러 클래스
 * @Description : 프로필 사진, 미팅룸 사진, 갤러리 사진 업로드
 *
 */

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/image")
public class ImageUploadController {

	@Value("${upload-images-path}")
	String path;
	
	@Autowired
	private ImageUploadService imageUploadService;

	@PostMapping("/profileUpload")
	public String InsertProfile(@RequestParam("iFile") MultipartFile file, @RequestParam("iUserEmail") String userEmail) throws Exception {
//		String uImage = path + "/" + userEmail + "-" + file.getOriginalFilename();
		String uImage = "C:/" + userEmail + "-" + file.getOriginalFilename();
//		Image image = new Image();
//		image.setIName(file.getOriginalFilename());
//		image.setIPath(imgPath);
//		image.setIUserName(userName);
		File dest = new File(uImage);
		file.transferTo(dest);
		
		return imageUploadService.InsertProfile(uImage) > 0 ? "OK" : "FAIL";
	}
	
	@PostMapping("/meetingroomImageUpload")
	public String InsertMeetingroomImageUpload(@RequestParam("iFile") MultipartFile file, @RequestParam("mrNo") String mrNo) throws Exception {
//		String mrImage = path + "/" + "mr-" + mrNo + "-" + file.getOriginalFilename();
		String mrImage = "C:/" + "mr-" + mrNo + "-" + file.getOriginalFilename();
//		Image image = new Image();
//		image.setIName(file.getOriginalFilename());
//		image.setIPath(imgPath);
//		image.setIUserName(userName);
		File dest = new File(mrImage);
		file.transferTo(dest);
		
		return imageUploadService.InsertMeetingroomImage(mrImage) > 0 ? "OK" : "FAIL";
	}

	@PostMapping("/galleryImageUpload")
	public String InsertGalleryImage(@RequestParam("iFile") MultipartFile file, @RequestParam("gNo") String gNo) throws Exception {
//		String gImage = path + "/" + "gallery-" + gNo + "-"  + file.getOriginalFilename();
		String gImage = "C:/" + "gallery-" + gNo + "-" + file.getOriginalFilename();
//		Image image = new Image();
//		image.setIName(file.getOriginalFilename());
//		image.setIPath(imgPath);
//		image.setIUserName(userName);
		File dest = new File(gImage);
		file.transferTo(dest);
		
		return imageUploadService.InsertGalleryImage(gImage) > 0 ? "OK" : "FAIL";
	}

	@GetMapping("/getImageList")
	public List<Image> getImageList() {
		return imageUploadService.getImageList();
	}
}
