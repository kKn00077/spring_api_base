package kr.co.moreturn.hwizza.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.moreturn.hwizza.config.security.JwtTokenProvider;
import kr.co.moreturn.hwizza.config.security.user.details.HwizzaUser;
import kr.co.moreturn.hwizza.user.mapper.UserMapper;
import kr.co.moreturn.hwizza.user.service.UserService;
import kr.co.moreturn.hwizza.user.vo.UserVO;
import kr.co.moreturn.hwizza.utils.exception.ErrorCode;
import kr.co.moreturn.hwizza.utils.exception.HwizzaException;
import lombok.extern.slf4j.Slf4j;

/** 
* @packageName : kr.co.moreturn.hwizza.user.service.impl 
* @fileName : UserServiceImpl.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : 유저 관련 서비스 인터페이스 구현
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	public int signupUser(UserVO vo) {
		// 패스워드 암호화
		String encodedPassword = passwordEncoder.encode(vo.getPwd());
		vo.setPwd(encodedPassword);
		
		// 핸드폰 번호 '-' 제거
		vo.replacePhoneNo();
		
		return userMapper.insertUser(vo);
	}

	@Override
	public UserVO getUserOfNickNm(String nick_nm) {
		return userMapper.selectUserOfNickNm(nick_nm);
	}

	@Override
	public Boolean nickNmDuplicateCheck(String nick_nm) {
		UserVO user = userMapper.selectUserOfNickNm(nick_nm);
		
		// 유저가 존재하면 true를 반환
		return user != null;
	}

	@Override
	public String loginUser(UserVO vo, Boolean isPk) {
		
		// vo로 받은 정보로 유저 정보 검색
		UserVO searchUserVO;
		
		// vo로 정보로 로그인에 사용할 user 객체 생성
		HwizzaUser user;
		
		Boolean is_auth = false;
		
		if(!isPk) {
			searchUserVO = userMapper.selectUserOfLogin(vo);
			user = new HwizzaUser(searchUserVO);			

			// 비밀번호가 일치 체크
			if(vo != null && searchUserVO != null) {
				is_auth = passwordEncoder.matches(vo.getPwd(), user.getPassword());
			}
		} else {
			searchUserVO = userMapper.selectUserOfUserNo(vo);
			user = new HwizzaUser(searchUserVO);
			is_auth = searchUserVO != null && (user.getPhoneNo().equals(vo.getPhone_no()));
		}
		
		// 인증에 실패하면(입력 받은 정보가 없거나 비밀번호가 일치하지 않으면) 예외 발생
		if(!is_auth) throw new HwizzaException(ErrorCode.UNAUTHORIZED_USER);
		
		// jwt 토큰 발급
		return jwtTokenProvider.createToken(user.getUsername(), null);
	}
	
	@Override
	public List<UserVO> getuUserPhoneNoAccountList(UserVO vo) {
		
		// 핸드폰 번호 '-' 제거
		vo.replacePhoneNo();
		
		// 핸드폰 번호가 일치하는 계정 리스트 반환
		return userMapper.selectUserListOfPhoneNo(vo);
	}

	@Override
	public UserVO getUserOfUserNo(UserVO vo) {
		return userMapper.selectUserOfUserNo(vo);
	}
	
	@Override
	public UserVO getUserOfUserNo(int user_no) {
		return userMapper.selectUserOfUserNo(user_no);
	}

}
