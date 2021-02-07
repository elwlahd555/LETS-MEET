package com.anjanda.letsmeet.imageupload.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.anjanda.letsmeet.imageupload.service.ImageUploadService;
import com.anjanda.letsmeet.repository.dto.Image;

public class ImageUploadController {
	private ImageUploadService imageUploadService;

	@PostMapping("/image/upload")
	public ResponseEntity<?> InsertImage(@ModelAttribute Image image) throws Exception {
		if (image != null)
			return new ResponseEntity(this.imageUploadService.InsertImage(image), HttpStatus.OK);
		return new ResponseEntity(this.imageUploadService.InsertImage(image), HttpStatus.NO_CONTENT);
	}
}
