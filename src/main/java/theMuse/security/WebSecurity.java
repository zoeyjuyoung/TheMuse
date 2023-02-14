package theMuse.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import theMuse.mapper.LoginMapper;
import theMuse.service.LoginService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	// 생성자 의존 주입
	private LoginService loginService;
	private LoginMapper loginMapper;
	private BCryptPasswordEncoder passwordEncoder;
	private Environment env;
	private JwtTokenUtil jwtTokenUtil;
	private JwtRequestFilter jwtRequestFilter;
	
	public WebSecurity(LoginService loginService, LoginMapper loginMapper, BCryptPasswordEncoder passwordEncoder, Environment env, JwtTokenUtil jwtTokenUtil, JwtRequestFilter jwtRequestFilter) {
		this.loginService = loginService;
		this.loginMapper = loginMapper;
		this.passwordEncoder = passwordEncoder;
		this.env = env;
		this.jwtTokenUtil = jwtTokenUtil;
		this.jwtRequestFilter = jwtRequestFilter;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**").permitAll();	// 모든 리소스에 대해 접근을 허용
	
		
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and().addFilter(getAuthenticationFilter());
//		.addFilterBefore(jwtRequestFilter, AuthenticationFilter.class).cors();
	}
	
	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(loginMapper, env, jwtTokenUtil);
		authenticationFilter.setAuthenticationManager(authenticationManager());
		return authenticationFilter;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginService).passwordEncoder(passwordEncoder);
	}
	
}
