package com.notsleep.letsmeet.login.service;

import java.util.Map;

import com.notsleep.letsmeet.repository.dto.UserDTO;

public interface LoginService {

	UserDTO login(Map<String, String> map) throws Exception;

}