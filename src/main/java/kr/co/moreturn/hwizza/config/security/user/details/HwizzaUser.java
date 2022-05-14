package kr.co.moreturn.hwizza.config.security.user.details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kr.co.moreturn.hwizza.user.vo.UserVO;
import lombok.RequiredArgsConstructor;

/** 
* @packageName : kr.co.moreturn.hwizza.config.security.user.details 
* @fileName : HwizzaUser.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : 스프링 시큐리티 내에서 사용하는 유저 클래스
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@RequiredArgsConstructor
public class HwizzaUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	private final UserVO user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return user.getPwd();
	}

	@Override
	public String getUsername() {
		return user.getNick_nm();
	}
	
	public String getPhoneNo() {
		return user.getPhone_no();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
