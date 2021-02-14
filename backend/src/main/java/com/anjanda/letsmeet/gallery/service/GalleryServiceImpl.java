package com.anjanda.letsmeet.gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjanda.letsmeet.repository.dto.Gallery;
import com.anjanda.letsmeet.repository.mapper.ImageMapper;

/**
 * 
 * @Date : 2021. 2. 14
 * @Team : AnJanDa
 * @author : 김동빈
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : Gallery 서비스 클래스
 * @Description
 *
 */

@Service
public class GalleryServiceImpl implements GalleryService {

	@Autowired
	private ImageMapper mapper;
	
	@Override
	public int insertGalleryImage(Gallery gallery) throws Exception {
		return mapper.insertGalleryImage(gallery);
	}

	@Override
	public List<Gallery> readGalleryImage(int gMrNo) throws Exception {
		return mapper.selectImageList();
	}

	@Override
	public int updateGalleryImage(Gallery gallery) throws Exception {
		return mapper.updateGalleryImage(gallery);
	}

	@Override
	public int deleteGalleryImage(Gallery gallery) throws Exception {
		return mapper.deleteGalleryImage(gallery);
	}

}
