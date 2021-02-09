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

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/image")
public class ImageUploadController {

	@Value("${upload-images-path}")
	String path;
	
	@Autowired
	private ImageUploadService imageUploadService;

	@PostMapping("/upload")
	public String InsertImage(@RequestParam("iFile") MultipartFile file, @RequestParam("iUserName") String userName) throws Exception {
//		String imgPath = path + "/" + file.getOriginalFilename();
		String imgPath = "C:/" + file.getOriginalFilename();
		Image image = new Image();
		image.setIName(file.getOriginalFilename());
//		image.setIPath(imgPath);
//		image.setIUserName(userName);
		File dest = new File(imgPath);
		file.transferTo(dest);
		
		return imageUploadService.InsertImage(image) > 0 ? "OK" : "FAIL";
	}

	@GetMapping("/getImageList")
	public List<Image> getImageList() {
		return imageUploadService.getImageList();
	}
}
