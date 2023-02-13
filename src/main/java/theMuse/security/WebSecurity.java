package theMuse.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
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
	
}
