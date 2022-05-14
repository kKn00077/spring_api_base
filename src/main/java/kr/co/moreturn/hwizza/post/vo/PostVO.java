package kr.co.moreturn.hwizza.post.vo;

import kr.co.moreturn.hwizza.utils.vo.DefaultVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/** 
* @packageName : kr.co.moreturn.hwizza.post.vo 
* @fileName : PostVO.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : POST 스키마 기반 VO 클래스
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
public class PostVO extends DefaultVO {

    // 필수로 받아오는 데이터
    private int post_no;
    
    // 필수로 받아오는 데이터
    private int user_no;
    
    // 필수로 받아오는 데이터
    @NonNull
    private String txt;
    
    private int like_cnt;

    private int review_cnt;
}
