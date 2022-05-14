package kr.co.moreturn.hwizza.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

/** 
* @packageName : kr.co.moreturn.hwizza.config.security 
* @fileName : WebSecurityConfig.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : 스프링 시큐리티 설정 클래스
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final JwtTokenProvider jwtTokenProvider;

	/** 
	* @methodName : getPasswordEncoder 
	* @author : Gyuna Kim 
	* @date : 2021.09.17 
	* @return 암호화를 위한 PasswordEncoder Bean 생성
	*/
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/** 
	* @methodName : authenticationManagerBean 
	* @author : Gyuna Kim 
	* @date : 2021.09.20 
	* @description : 인증 관리를 위한 authenticationManager를 Bean 등록함
	* @return
	* @throws Exception 
	*/
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	/**
	 * @methodName : configure
	 * @author : Gyuna Kim
	 * @date : 2021.09.17
	 * @description : 
	 * 스프링 시큐리티 룰을 무시하게 하는 url 규칙(여기 등록하면 규칙 적용하지 않음) 
	 * 규칙을 더 추가하고 싶을 경우 .antMatchers 메서드를 추가해 Url 규칙을 추가한다. 
	 * (전체 접근이 가능한 파일이나 이미지, css같은 리소스만 추가할 것)
	 * @param web
	 * @throws Exception
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/image/**");
	}

	/** 
	* @methodName : configure 
	* @author : Gyuna Kim 
	* @date : 2021.09.17 
	* @description : 스프링 시큐리티 규칙 설정
	* @param http
	* @throws Exception 
	*/
	@Override 
	protected void configure(HttpSecurity http) throws Exception { 
		http
		.cors().and() // cors 정책 사용 설정
        .csrf().disable() // 토큰 사용을 하기 때문에 csrf 설정은 비활성화
        .httpBasic().disable() // 기본 HTTP 방식의 로그인 비활성화
        .formLogin().disable()// loginProcessingUrl("/account/login") // login 프로세싱 api url 설정
        //.and()
        .sessionManagement() // 토큰을 이용한 인증을 위해 session 설정
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 토큰을 이용하기 때문에 세션을 사용하지 않겠다고 설정
            .and()
		.authorizeRequests() // 보호된 리소스 URI에 접근할 수 있는 권한을 설정 
        	.antMatchers("/account/signup").permitAll() // 전체 접근 허용
        	.antMatchers("/account/login").permitAll() // 전체 접근 허용
        	.antMatchers("/account/login/choice").authenticated() // 인증 요청
        	.anyRequest().authenticated() // 그 외는 인증 요청
        	.and()
        .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                UsernamePasswordAuthenticationFilter.class); // JWT를 사용하기 위해 커스텀한 JWT 필터를 적용해준다.
		
	}


}
