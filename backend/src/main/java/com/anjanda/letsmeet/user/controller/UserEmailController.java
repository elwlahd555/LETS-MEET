package com.anjanda.letsmeet.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjanda.letsmeet.user.service.UserEmailService;
import com.anjanda.letsmeet.user.service.UserEmailServiceImpl;

@RestController
@RequestMapping("user/join/service")
public class UserEmailController {
	
	@Autowired
	UserEmailService userEmailService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/mail")
	public ResponseEntity<String> emailConfirm(String uEmail) throws Exception {
		logger.info("Post email Confirm");
		System.out.println("전달 받은 이메일 : " + uEmail);
		userEmailService.sendSimpleMessage(uEmail);
		return new ResponseEntity<String>("코드 전송 성공", HttpStatus.OK);
	}
	
	@PostMapping("/verifyCode")
	public ResponseEntity<String> verifyCode(String code){
		logger.info("Post VerifyCode");
		int result = 0;
		System.out.println("Code : " + code);
		System.out.println("Code Match : " + UserEmailServiceImpl.ePw.equals(code));
		if(UserEmailServiceImpl.ePw.equals(code)) {
			return new ResponseEntity<String>("코드 인증 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("코드 인증 실패", HttpStatus.NO_CONTENT);
		
	}
}
