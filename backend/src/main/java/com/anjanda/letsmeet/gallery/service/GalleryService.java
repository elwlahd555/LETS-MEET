package com.anjanda.letsmeet.gallery.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.Gallery;

/**
 * 
 * @Date : 2021. 2. 14
 * @Team : AnJanDa
 * @author : 김동빈
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : Gallery 서비스 인터페이스 클래스
 * @Description
 *
 */

public interface GalleryService {
	/* C :: 갤러리 이미지 추가 */
	int insertGalleryImage(Gallery gallery) throws Exception;
	
	/* R :: 갤러리 이미지 조회 */
	List<Gallery> readGalleryImage(int gMrNo) throws Exception;

	/* U :: 갤러리 이미지 수정 */
	int updateGalleryImage(Gallery gallery) throws Exception;
	
	/* D :: 갤러리 이미지 삭제  */
	int deleteGalleryImage(Gallery gallery) throws Exception;
}
