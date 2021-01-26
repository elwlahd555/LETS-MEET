package com.anjanda.letsmeet.login.service;

import java.util.Map;

import com.anjanda.letsmeet.repository.dto.User;

public interface LoginService {

	User login(Map<String, String> map) throws Exception;

}