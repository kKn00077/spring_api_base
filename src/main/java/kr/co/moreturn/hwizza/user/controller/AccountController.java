package kr.co.moreturn.hwizza.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.moreturn.hwizza.config.security.user.details.HwizzaUser;
import kr.co.moreturn.hwizza.user.service.UserService;
import kr.co.moreturn.hwizza.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

/** 
* @packageName : kr.co.moreturn.hwizza.user.controller 
* @fileName : AccountController.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : 계정 관련 컨트롤러
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<Object> signUp(@RequestBody UserVO vo) {
		// nicknm, pwd, phone
		userService.signupUser(vo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserVO vo) {
		// nicknm, pwd, phone
		Map<String, Object> map = new HashMap<String, Object>();
		String jwt = userService.loginUser(vo, false);
		List<UserVO> list = userService.getuUserPhoneNoAccountList(vo);
		
		map.put("token", jwt);
		
		if( (!list.isEmpty()) && (list.size() > 0) )
			map.put("list", list);
		
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@PostMapping("/login/choice")
	public ResponseEntity<Object> loginChoice(@RequestBody UserVO vo, 
												@AuthenticationPrincipal HwizzaUser user) {
		// token + userno
		
		Map<String, Object> map = new HashMap<String, Object>();
		vo.setPhone_no(user.getPhoneNo());
		
		String jwt = userService.loginUser(vo, true);
		
		map.put("token", jwt);
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
}
