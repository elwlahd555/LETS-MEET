package com.anjanda.letsmeet.friend.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.User;

/**
 * 
 * @Date : 2021. 2. 4.
 * @Team : AnJanDa
 * @author : 김지현
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : Friend 서비스 인터페이스 클래스
 * @Description
 *
 */

public interface FriendService {

	/* C :: 사용자의 친구 추가 */
	int createFriend(int me, User user) throws Exception;

	/* R :: 사용자의 친구 조회 */
	List<User> reviewFriend(User user) throws Exception;

	/* D :: 사용자의 친구 삭제 */
	boolean deleteFriend(int me, User user) throws Exception;

}