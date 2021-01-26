package com.anjanda.letsmeet;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 
 * @Date 2021. 1. 26.
 * @Team AnJanDa
 * @author 개발자명
 * @Project : Test
 * @Function : DB연결을 위한 Mybatis 설정 클래스
 * @Description : 
 *
 */

@Configuration
@MapperScan(basePackages="com.anjanda.letsmeet.mappers")
public class MybatisConfiguration {
	@Bean
	public SqlSessionFactory sqlSessionFactory (DataSource dataSource) throws Exception {
			SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
			sqlSessionFactory.setDataSource(dataSource);
			sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml"));
			return sqlSessionFactory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSession (SqlSessionFactory sqlSessionFactory) {
	    return new SqlSessionTemplate(sqlSessionFactory);
	}
}