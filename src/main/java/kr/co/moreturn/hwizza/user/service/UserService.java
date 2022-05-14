package kr.co.moreturn.hwizza.user.service;

import java.util.List;

import kr.co.moreturn.hwizza.user.vo.UserVO;

/** 
* @packageName : kr.co.moreturn.hwizza.user.service 
* @fileName : UserService.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : 유저 관련 서비스 인터페이스
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

public interface UserService {
	// 회원가입
    public int signupUser(UserVO vo);

    // 닉네임 검색
    public UserVO getUserOfNickNm(String nick_nm);

    // 닉네임 중복체크
    public Boolean nickNmDuplicateCheck(String nick_nm);

    // 로그인 (jwt 토큰 반환)
    public String loginUser(UserVO vo, Boolean isPk);

    // 복수 계정 조회
    public List<UserVO> getuUserPhoneNoAccountList(UserVO vo);

    // key값(user_no)으로 user 조회
    public UserVO getUserOfUserNo(UserVO vo);
    
    // key값(user_no)으로 user 조회
    public UserVO getUserOfUserNo(int user_no);
}
