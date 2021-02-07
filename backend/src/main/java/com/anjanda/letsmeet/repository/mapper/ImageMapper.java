package com.anjanda.letsmeet.repository.mapper;

import com.anjanda.letsmeet.repository.dto.Image;

public interface ImageMapper {
	/* C :: 이미지 추가 */
	public int insertImage(Image image) throws Exception;
}
