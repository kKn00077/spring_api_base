package kr.co.moreturn.hwizza.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moreturn.hwizza.user.vo.UserVO;

/** 
* @packageName : kr.co.moreturn.hwizza.user.mapper 
* @fileName : UserMapper.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : 유저 관련 매퍼 (implemant를 하지 않아도 spring mybatis에서 자동으로 xml 쿼리문과 매핑시켜준다)
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@Mapper
public interface UserMapper {
	
	public int insertUser(UserVO vo);

    // user nick_nm 으로 select
    public UserVO selectUserOfNickNm(String nick_nm);

    // user nick_nm, phone_no로 조회
    public UserVO selectUserOfLogin(UserVO vo);
    
    // user list phone_no로 조회
    public List<UserVO> selectUserListOfPhoneNo(UserVO vo);

    // user key값으로 검색
    public UserVO selectUserOfUserNo(UserVO vo);
    
    // user key값으로 검색
    public UserVO selectUserOfUserNo(int user_no);
}
