package com.anjanda.letsmeet.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjanda.letsmeet.repository.dto.User;
import com.anjanda.letsmeet.secure.encrypt.SHA256SALT;
import com.anjanda.letsmeet.secure.jwt.JwtService;
import com.anjanda.letsmeet.user.service.UserService;

/**
 * 
 * @Date : 2021. 2. 4.
 * @Team : AnJanDa
 * @author : 김지현
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : 유저 컨트롤러 클래스
 * @Description
 *	- 유저 관련 컨트롤러 클래스
 *	- REST API 적용
 *	- 이메일 인증 적용
 *	- 회원가입시, SALT 및 암호화 비밀번호 생성
 */

@RestController
@RequestMapping("/user")
public class UserController {
	
	/* JWT 객체 불러오기 */
	@Autowired
	private JwtService jwtService;
	
	/* 유저 서비스 객체 불러오기 */
	@Autowired
	private UserService userService;
	
	/* C :: 회원 가입 => 여기서, salt 값 생성해서 넣어주고, salt값으로 sha256 암호화한 비번 데이터까지 넣어서 회원 가입시켜야함. */
	@CrossOrigin(origins="*")
	@PostMapping("/join")
	public ResponseEntity<String> createUser(User user) throws Exception {
		// 이메일 인증 확인 절차 받아야만 가능하다는걸 처리해주어야함....?
		
		System.out.println("가입할 유저 email" + user.getuEmail());
		
		if(userService.createUser(user) > 0) {	
			return new ResponseEntity<String>("회원가입 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("회원가입 실패", HttpStatus.NO_CONTENT);

	}
	
	/* R :: 회원 개인 정보 조회 */
	@GetMapping("/mypage")
	public ResponseEntity<Map<String, Object>> reviewUser(HttpServletRequest request) {
		HttpStatus status = null;
		Map<String, Object> resultMap = new HashMap<>();
		
		try {
			status = HttpStatus.ACCEPTED;
		} catch (RuntimeException e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	/* U :: 수정 */
	@PutMapping("/mypage/{uEmail}")	// uid로 해야하려나.. uEmail 이거 중복될걱같은데,,,
	public ResponseEntity<String> updateUser(@RequestBody User user) throws Exception {
		System.out.println(user+"유저정보"+user.getuPassword());
		if(userService.updateUser(user) >= 0) {
			return new ResponseEntity<String>("업데이트 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("업데이트 실패", HttpStatus.NO_CONTENT);
	}
	
	/* D :: 삭제 */
	@DeleteMapping("/delete/{uEmail}")	// uid로..? uEmail로???
	public ResponseEntity<?> deleteUser(@PathVariable("uEmail") String email) {
		HttpStatus status = null;
		Map<String, Object> resultMap = new HashMap<>();
		
		User check = new User();
		check.setuEmail(email);
		
		try {
			if(userService.deleteUser(check) >= 0) {
				resultMap.put("message",  "회원이 삭제되었습니다.");
				status = HttpStatus.ACCEPTED;
			}
			else {
				resultMap.put("message", "회원 삭제하는데 문제가 발생하였습니다.");
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} catch(Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>("회원삭제처리", status);
	}

	
	//기본 CRUD 외 추가 기능
	/* 유저 이메일 중복체크 */
	@GetMapping("/join/check/email/{uEmail}")
	public ResponseEntity<?> checkEmail(@PathVariable(name="email") String email) {
		User check = new User();
		check.setuEmail(email);
		try {
			if(userService.existEmail(check)==0) {	// 이메일 중복한 게 없으면 0
				return new ResponseEntity<>("true", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("false", HttpStatus.OK);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("false", HttpStatus.BAD_GATEWAY);
	}
}


