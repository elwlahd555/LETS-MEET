package com.anjanda.letsmeet.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjanda.letsmeet.repository.dto.User;
import com.anjanda.letsmeet.repository.mapper.UserMapper;

/**
 * 
 * @Date : 2021. 2. 1.
 * @Team : AnJanDa
 * @author : 개발자명
 * @Project : 레쓰밋 :: backend
 * @Function : 유저 서비스 클래스
 * @Description
 *	- 로그인
 *	- CRUD
 *	- 기타 작업 메소드
 */

@Service
public class UserServiceImpl implements UserService {

	/* 유저 매퍼 객체 불러오기 */
	@Autowired
	private UserMapper mapper;
	
//	/* 비밀번호를 해쉬로 저장하기 위한 인코더 */
//	@Autowired
//	private BCryptPasswordEncoder encoder;
	
	/* 로그인 메소드 */
	@Override
	public User login(User user) throws Exception {
		User check = mapper.selectUser(user);
		if(user.getuPassword().equals(check.getuPassword()))
			return check;
		else
			return null;
	}
	
	/* C :: 회원 가입 메소드 */
	@Override
	public int createUser(User user) throws Exception {
//		String rawPassword = user.getuPassword(); // 비밀번호 원문
//		String encPassword = encoder.encode(rawPassword); // 해쉬
//		user.setuPassword(rawPassword);
		return mapper.insertUser(user);
	}

	/* C :: 카카오 회원 가입 메소드 */
	@Override
	public int createKakaoUser(User user) throws Exception {
//		String rawPassword = user.getuPassword(); // 비밀번호 원문
//		String encPassword = encoder.encode(rawPassword); // 해쉬
//		user.setuPassword(rawPassword);
		return mapper.insertKakaoUser(user);
	}
	
	/* R :: 회원 상세 조회 메소드 */
	@Override
	public User selectUser(User user) throws Exception {
		return mapper.selectUser(user);
	}
	
	/* U :: 회원 정보 수정 메소드 */
	@Override
	public int updateUser(User user) throws Exception {
		return mapper.updateUser(user);
	}
	
	/* D :: 회원 탈퇴 메소드 */
	@Override
	public int deleteUser(User user) throws Exception {
		return mapper.deleteUser(user);
	}
	
	// CRUD 외 추가 기능 
	/* 이메일 중복 체크 */
	@Override
	public int existEmail(User user) throws Exception {
		return mapper.existEmail(user);
	}
}






//우리 동빈이가 작업한 세션 로그인 서비스 클래스
/*
package com.anjanda.letsmeet.login.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjanda.letsmeet.repository.dto.User;
import com.anjanda.letsmeet.repository.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginMapper mapper;

	@Override
	public User login(Map<String, String> map) throws Exception {
		if (map.get("email") == null || map.get("password") == null) // if email or password is null then return null
			return null;
		return mapper.selectLogin(map); // if not either email or password are null then return selectLogin
	}

}
*/