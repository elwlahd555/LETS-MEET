package com.anjanda.letsmeet.imageupload.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.Image;
import com.anjanda.letsmeet.repository.dto.MeetingRoom;
import com.anjanda.letsmeet.repository.dto.User;

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

	public int UpdateProfile(User user) throws Exception;

	public int UpdateMeetingroomImage(MeetingRoom meetingroom) throws Exception;

	public int UpdateGalleryImage(String gImage) throws Exception;

}
