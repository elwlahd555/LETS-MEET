package com.anjanda.letsmeet.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.anjanda.letsmeet.repository.dto.Image;

@Mapper
public interface ImageMapper {
	/* C :: 이미지 추가 */
	public int insertImage(Image image) throws Exception;
	
	public List<Image> getImageList();
}
