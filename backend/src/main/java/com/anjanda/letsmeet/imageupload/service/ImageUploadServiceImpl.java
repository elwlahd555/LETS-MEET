package com.anjanda.letsmeet.imageupload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjanda.letsmeet.repository.dto.Image;
import com.anjanda.letsmeet.repository.mapper.ImageMapper;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {
	@Autowired
	private ImageMapper mapper;

	@Override
	public int InsertImage(Image image) throws Exception {
		return mapper.insertImage(image);
	}

	@Override
	public List<Image> getImageList() {
		return mapper.getImageList();
	}

}
