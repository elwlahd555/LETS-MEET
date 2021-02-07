package com.anjanda.letsmeet.user.service;

import com.anjanda.letsmeet.repository.dto.User;

/**
 * 
 * @Date : 2021. 2. 5.
 * @Team : AnJanDa
 * @author : 김동빈, 김지현, 임호빈
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : 유저 서비스 클래스
 * @Description
 *
 */

public interface UserService {

	/* 로그인 메소드 */
	User login(User user) throws Exception;

	/* C :: 회원 가입 메소드 */
	int createUser(User user) throws Exception;

	/* C :: 카카오 회원 가입 메소드 */
	int createKakaoUser(User user) throws Exception;

	/* R :: 로그인을 위한 조회*/
	public User selectUserLogin(User user) throws Exception;
	
	/* R :: 회원 상세 조회 메소드 */
	public User selectUser(User user) throws Exception;

	/* U :: 회원 정보 수정 메소드 */
	public int updateUser(User user) throws Exception;

	/* D :: 회원 탈퇴 메소드 */
	public int deleteUser(User user) throws Exception;

	// CRUD 외 추가 기능 
	/* 이메일 중복 체크 */
	public int existEmail(User user) throws Exception;

	/* 토큰에서 얻은 uNo로 유저 검색  */
	public User selectUserByUNo(int uNoInToken) throws Exception;
}