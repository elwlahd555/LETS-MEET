package com.anjanda.letsmeet.login.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anjanda.letsmeet.login.service.LoginService;
import com.anjanda.letsmeet.repository.dto.User;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@GetMapping("/login")
	public void login(Model model) {
		model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인 해주세요");
	}

	@PostMapping("/login")
	public String service(@RequestParam Map<String, String> map, HttpSession session, HttpServletResponse response,
			Model model) throws Exception {
		try {
			User user = loginService.login(map);
			if (user != null) { // 유저 정보가 왔을 경우
				session.setAttribute("userinfo", user);
				System.out.println(user.getuEmail());
				Cookie cookie = new Cookie("user_id", user.getuEmail());
				cookie.setPath("/");
				if ("saveok".equals(map.get("idsave"))) { // id저장 하면
					cookie.setMaxAge(60 * 60 * 24 * 365 * 50); // 단위가 초이기 때문에 초*분*시간*일*년을 하면 최대 ~년간 저장 된다.(윤년 고려 안함)
				} else {
					cookie.setMaxAge(0); // 저장 안하면 쿠키 저장 안함(0초간 저장)
				}
				response.addCookie(cookie);
			} else { // 유저 정보가 오지 않았으면 로그인 화면으로 리다이렉트
				return "redirect:login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			return "error/loginError"; // 로그인 중 문제가 발생했으니 로그인 에러로 이동 (로그인 에러 페이지 따로 만들어야함)
		}
		return "redirect:/main"; // 메인으로 리다이렉트 보낸다.
	}
//
//	// googleLogin
//	final static String GOOGLE_AUTH_BASE_URL = "https://accounts.google.com/o/oauth2/v2/auth";
//	final static String GOOGLE_TOKEN_BASE_URL = "https://oauth2.googleapis.com/token";
//	final static String GOOGLE_REVOKE_TOKEN_BASE_URL = "https://oauth2.googleapis.com/revoke";
//
//	@Value("${api.client_id}")
//	String clientId;
//	@Value("${api.client_secret}")
//	String clientSecret;
//
//
//	/**
//	 * Authentication Code를 전달 받는 엔드포인트
//	 **/
//	@GetMapping("google/auth")
//	public String googleAuth(Model model, @RequestParam(value = "code") String authCode)
//			throws JsonProcessingException {
//		
//		//HTTP Request를 위한 RestTemplate
//		RestTemplate restTemplate = new RestTemplate();
//
//		//Google OAuth Access Token 요청을 위한 파라미터 세팅
//		GoogleOAuthRequest googleOAuthRequestParam = GoogleOAuthRequest
//				.builder()
//				.clientId(clientId)
//				.clientSecret(clientSecret)
//				.code(authCode)
//				.redirectUri("http://localhost:8080/login/google/auth")
//				.grantType("authorization_code").build();
//
//		
//		//JSON 파싱을 위한 기본값 세팅
//		//요청시 파라미터는 스네이크 케이스로 세팅되므로 Object mapper에 미리 설정해준다.
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//		mapper.setSerializationInclusion(Include.NON_NULL);
//
//		//AccessToken 발급 요청
//		ResponseEntity<String> resultEntity = restTemplate.postForEntity(GOOGLE_TOKEN_BASE_URL, googleOAuthRequestParam, String.class);
//
//		//Token Request
//		GoogleOAuthResponse result = mapper.readValue(resultEntity.getBody(), new TypeReference<GoogleOAuthResponse>() {
//		});
//		
//		System.out.println(resultEntity.getBody());
//
//		//ID Token만 추출 (사용자의 정보는 jwt로 인코딩 되어있다)
//		String jwtToken = result.getIdToken();
//		String requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo")
//		.queryParam("id_token", jwtToken).encode().toUriString();
//		
//		String resultJson = restTemplate.getForObject(requestUrl, String.class);
//		
//		Map<String,String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>(){});
//		model.addAllAttributes(userInfo);
//		model.addAttribute("token", result.getAccessToken());
//		System.out.println(userInfo);
//
//
//
//
//		return "/google.html";
//
//	}
//
//	/**
//	 * 토큰 무효화 
//	 **/
//	@GetMapping("google/revoke/token")
//	@ResponseBody
//	public Map<String, String> revokeToken(@RequestParam(value = "token") String token) throws JsonProcessingException {
//
//		Map<String, String> result = new HashMap<>();
//		RestTemplate restTemplate = new RestTemplate();
//		final String requestUrl = UriComponentsBuilder.fromHttpUrl(GOOGLE_REVOKE_TOKEN_BASE_URL)
//				.queryParam("token", token).encode().toUriString();
//		
//		System.out.println("TOKEN ? " + token);
//		
//		String resultJson = restTemplate.postForObject(requestUrl, null, String.class);
//		result.put("result", "success");
//		result.put("resultJson", resultJson);
//
//		return result;
//
//	}
//	
	@GetMapping("/auth/kakao/callback")
	public @ResponseBody String kakaoCallback(String code) { // Data를 return 해주는 controller method
//		System.out.println("카카오 인증 완료 : 코드값 : " + code);
		
		// POST방식으로 key=value 데이터를 요청 (카카오쪽으로)
		// Restrofit2
		// OkHttp
		// RestTemplate
		
		RestTemplate rt = new RestTemplate();
		
		// HttpHeader 오브젝트 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// HttpBody 오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "deace353f1fd1555201a07f914bc5598");
		params.add("redirect_uri", "http://localhost:8080/auth/kakao/callback");
		params.add("code", "code");
		
		// HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
				new HttpEntity<>(params, headers);
		
		// Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
		ResponseEntity<String> response = rt.exchange(
				"https://kauth.kakao.com/oauth/token",
				HttpMethod.POST,
				kakaoTokenRequest,
				String.class
		);
		
		return "카카오 토큰 요청 완료 : 토큰요청에 대한 응답 : " + response;
	}
}
