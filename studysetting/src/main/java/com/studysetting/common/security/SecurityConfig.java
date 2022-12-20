package com.studysetting.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.studysetting.domain.User.MemberService;

import lombok.AllArgsConstructor;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig {
	//이제 프로젝트 사이트가 잠겨서 비밀번호를 쳐야 접근할 수 있음. 
//	private final UserDetailsService userDetailsService;
//	public class SecurityConfig() {
//		super();
//	}
	
	private final MemberService userService;
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		
//	}
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//	}
	
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	}
	
//	protected void configure(HttpSecurity http) throws Exception {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			//정상적인 사용자가 의도치 않은 위조요청을 보내는 것을 disable함
			.authorizeRequests()
				.antMatchers("/**").permitAll() // 이하 모든 url 은 모두 허가
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated() //anyRequest,설정하지 않은 나머지는 authenticated,권한이 있으면
				.and()
			.formLogin()
//				.loginPage("/home.html") //첫페이지
				.loginPage("/login")
//				.loginProcessingUrl("/signin") //사용자 이름과 암호를 제출할 URL
				.defaultSuccessUrl("/") //로그인 성공 후 리다이렉트
				.and()
			.logout()
				.logoutSuccessUrl("/login") //로그아웃 성공 시 리다이렉트
				.invalidateHttpSession(true); //session 종료
		return http.build();
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	//spring5에서 암호 인코더를 정의한다. BCryptPassworedEncoder를 사용했다.

//	@Autowired
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication()
//		.rolePrefix("ROLE_")
//	}
}