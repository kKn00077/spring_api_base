package kr.co.moreturn.hwizza.config.security.user.details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.moreturn.hwizza.config.security.user.details.HwizzaUser;
import kr.co.moreturn.hwizza.user.mapper.UserMapper;
import kr.co.moreturn.hwizza.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

/** 
* @packageName : kr.co.moreturn.hwizza.config.security.user.details.service 
* @fileName : HwizzaUserDetailsService.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : 스프링 시큐리티 내에서 사용하는 서비스 클래스
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@Slf4j
@Service
public class HwizzaUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserMapper userMapper;

	/** 
	* @methodName : loadUserByUsername 
	* @author : Gyuna Kim 
	* @date : 2021.09.21 
	* @description : username(아이디가 될 수도 있고 pk값이 될 수도 있다. 이 코드에서는 pk값으로 사용 중이다.)
	* 을 통해서 User를 찾아오는 스프링 시큐리티 서비스 메서드. 스프링 시큐리티 내부에서 이 메서드를 불러오도록 되어있으므로
	* 필수 구현해야한다.
	* @param username
	* @return
	* @throws UsernameNotFoundException 
	*/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UsernameNotFoundException e = new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		
		// null 값이거나 빈 문자열이면 exception 발생 
		if(username == null || username.isBlank())
			throw e;
		
		UserVO vo = userMapper.selectUserOfNickNm(username);
		
		if(vo == null) throw e;
		
		return new HwizzaUser(vo);
	}

}
