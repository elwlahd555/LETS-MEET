package com.anjanda.letsmeet.repository.dto;

import lombok.Data;

// Data 어노테이션은 getter, setter를 자동 생성합니다.
@Data

public class SocketVO {
    // 유저의 이름을 저장하기 위한 변수
    private String userName;

    // 메시지의 내용을 저장하기 위한 변
    private String content;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
}
