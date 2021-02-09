package com.anjanda.letsmeet.imageupload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjanda.letsmeet.repository.dto.Image;
import com.anjanda.letsmeet.repository.mapper.ImageMapper;

/**
 * 
 * @Date : 2021. 2. 8.
 * @Team : AnJanDa
 * @author : 김동빈
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : 이미지 업로드 서비스 클래스
 * @Description
 *
 */

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

	@Override
	public int InsertProfile(String uImage) throws Exception {
		return mapper.insertProfile(uImage);
	}

	@Override
	public int InsertMeetingroomImage(String mrImage) throws Exception {
		return mapper.insertMeetingroomImage(mrImage);
	}

	@Override
	public int InsertGalleryImage(String gImage) throws Exception {
		return mapper.insertGalleryImage(gImage);
	}

}
