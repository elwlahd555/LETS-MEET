package com.anjanda.letsmeet.imageupload.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.Image;

public interface ImageUploadService {

	public int InsertImage(Image image) throws Exception;

	public List<Image> getImageList();

}
