package com.anjanda.letsmeet.imageupload.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.Image;

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

public interface ImageUploadService {

	public int InsertImage(Image image) throws Exception;

	public List<Image> getImageList();

	public int InsertProfile(String uImage) throws Exception;

	public int InsertMeetingroomImage(String mrImage) throws Exception;

	public int InsertGalleryImage(String gImage) throws Exception;

}
