package kr.co.moreturn.hwizza.user.vo;

import java.util.Date;
import kr.co.moreturn.hwizza.utils.vo.DefaultVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/** 
* @packageName : kr.co.moreturn.hwizza.user.vo 
* @fileName : UserVO.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : USER 테이블 스키마 기반 VO 클래스
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
public class UserVO extends DefaultVO {
	
	private int user_no;
    
    // 필수로 받아오는 데이터
    @NonNull
    private String nick_nm;
    
    // 필수로 받아오는 데이터
    @NonNull
    private String pwd;
    
    // 필수로 받아오는 데이터
    @NonNull
    private String phone_no;
    
    private String user_nm;
    private Date birth_date;
    private char gender;
    private String user_image;
    private String txt;
    private String job;
    private char receive_yn;
    private int post_cnt;
    private int follower_cnt;
    private int follow_cnt;
    private int cash_rate;


    /** 
    * @methodName : replacePhoneNo 
    * @author : Gyuna Kim 
    * @date : 2021.09.21 
    * @description 핸드폰 번호 문자열 replace
    */
    public void replacePhoneNo(){
        String phone_no_format = this.phone_no.replaceAll("-", "");
        setPhone_no(phone_no_format);
    }
}
