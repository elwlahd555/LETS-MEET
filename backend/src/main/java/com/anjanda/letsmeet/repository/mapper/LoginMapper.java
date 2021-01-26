package com.anjanda.letsmeet.repository.mapper;

import java.util.Map;

import com.anjanda.letsmeet.repository.dto.User;

public interface LoginMapper {

	User selectLogin(Map<String, String> map);

}
