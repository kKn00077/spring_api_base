package kr.co.moreturn.hwizza.utils.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/** 
* @packageName : kr.co.moreturn.hwizza.utils.vo 
* @fileName : DefaultVO.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : 기본적으로 들어가는 필드 VO
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@Data
@NoArgsConstructor
public class DefaultVO {
	// 필수로 받아오는 데이터
    @NonNull
    private Date reg_dt;
    
    private Date edit_dt;
}
