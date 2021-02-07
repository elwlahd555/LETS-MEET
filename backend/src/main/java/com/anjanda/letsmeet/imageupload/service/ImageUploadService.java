package com.anjanda.letsmeet.imageupload.service;

import org.springframework.util.MultiValueMap;

import com.anjanda.letsmeet.repository.dto.Image;

public interface ImageUploadService {

	public int InsertImage(Image image) throws Exception;

}
