package com.anjanda.letsmeet.repository.dto;

import lombok.Data;

@Data
public class GoogleOAuthResponse {
	private String accessToken;
	private String expiresln;
	private String refreshToken;
	private String scope;
	private String tokenType;
	private String idToken;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getExpiresln() {
		return expiresln;
	}
	public void setExpiresln(String expiresln) {
		this.expiresln = expiresln;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public String getIdToken() {
		return idToken;
	}
	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}
	
	
}
