package kr.co.moreturn.hwizza.post.vo;

import kr.co.moreturn.hwizza.utils.vo.DefaultVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/** 
* @packageName : kr.co.moreturn.hwizza.post.vo 
* @fileName : PostReReviewLikeVO.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : REREVIEW_LIKE 스키마 기반 VO 클래스
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
public class PostReReviewLikeVO extends DefaultVO{
    private int user_no;
    private int rereview_no;
}
