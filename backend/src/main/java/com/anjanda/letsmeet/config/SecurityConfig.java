package com.anjanda.letsmeet.config;

public class SecurityConfig{
	
}
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/guest/**").permitAll()
//                .antMatchers("/manager/**").hasRole("MANAGER")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/swagger-resources/**").permitAll() //swagger
//                .antMatchers("/swagger-ui.html").permitAll()
//                .antMatchers("/v2/api-docs").permitAll()
//                .antMatchers("/webjars/**").permitAll();
//
//        http.formLogin();
//        http.exceptionHandling().accessDeniedPage("/accessDenied");
//        http.logout().logoutUrl("/logout").invalidateHttpSession(true);
//
//    }
//    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("manager")
//                .password("{noop}1111")
//                .roles("MANAGER");
//    }
//}
