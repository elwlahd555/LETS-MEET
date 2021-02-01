package com.anjanda.letsmeet.user.service;

import com.anjanda.letsmeet.repository.dto.User;

/**
 * 
 * @Date : 2021. 2. 1.
 * @Team : AnJanDa
 * @author : 개발자명
 * @Project : 레쓰밋 :: backend
 * @Function : 유저서비스 인터페이스 클래스
 * @Description
 *
 */

public interface UserService {

	/* 로그인 메소드 */
	User login(User user) throws Exception;

	/* C :: 회원 가입 메소드 */
	int createUser(User user) throws Exception;

	/* R :: 회원 상세 조회 메소드 */
	User selectUser(User user) throws Exception;

	/* U :: 회원 정보 수정 메소드 */
	int updateUser(User user) throws Exception;

	/* D :: 회원 탈퇴 메소드 */
	int deleteUser(User user) throws Exception;

	// CRUD 외 추가 기능 
	/* 이메일 중복 체크 */
	int existEmail(User user) throws Exception;

}