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
