package com.anjanda.letsmeet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// 24라인에서.. 컨트롤러 연결시켜야하는데 흠?
@Bean
public Docket postsApi() {
	return new Docket(DocumentationType.SWAGGER_2)
			.groupName("ssafyVueBoard")
			.apiInfo(apiInfo())
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.anjanda.letsmeet"))
			.paths(PathSelectors.ant("/api/**"))
			.build();
}

private ApiInfo apiInfo() {
	return new ApiInfoBuilder().title("레쓰밋(Let's Meet)")
			.description("약속을 잡아주고 관리해주는 웹 앱 : 레쓰밋(Let's Meet)")
			.termsOfServiceUrl("https://www.notion.so/oct14jh/Let-s-Meet-8ad9360ca0684bd98b905fd383c9c30b")
			.license("안잔다 Team - 레쓰밋 프로젝트")
			.licenseUrl("khyun7621@naver.com").version("1.0").build();
}

}