package com.notsleep.letsmeet.repository.mapper;

import java.util.Map;

import com.notsleep.letsmeet.repository.dto.UserDTO;

public interface LoginMapper {

	UserDTO selectLogin(Map<String, String> map);

}
