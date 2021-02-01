package com.anjanda.letsmeet.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.anjanda.letsmeet.repository.dto.User;

@Mapper
public interface UserMapper {
	/* C :: 회원 가입 메소드 */
	public int insertUser(User user) throws Exception;
	
	/* R :: 회원상세정보조회 메소드 */
	public User selectUser(User user) throws Exception;

	/* U :: 회원정보 수정 메소드 */
	public int updateUser(User user) throws Exception;
	
	/* D :: 회원 탈퇴 메소드 */
	public int deleteUser(User user) throws Exception;
	
	// CRUD 외 추가 기능
	/* 이메일 중복 체크 메소드 */
	public int existEmail(User user) throws Exception;
}
