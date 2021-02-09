package com.anjanda.letsmeet.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.anjanda.letsmeet.repository.dto.Image;
import com.anjanda.letsmeet.repository.dto.MeetingRoom;
import com.anjanda.letsmeet.repository.dto.User;

@Mapper
public interface ImageMapper {
	/* C :: 이미지 추가 */
	public int insertImage(Image image) throws Exception;
	
	public List<Image> selectImageList();

	public int updateProfile(User user) throws Exception;

	public int updateMeetingroomImage(MeetingRoom meetingroom) throws Exception;

	public int updateGalleryImage(String gImage) throws Exception;
}
