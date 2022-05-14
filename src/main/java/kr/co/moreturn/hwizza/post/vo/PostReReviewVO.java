package kr.co.moreturn.hwizza.post.vo;



import kr.co.moreturn.hwizza.utils.vo.DefaultVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/** 
* @packageName : kr.co.moreturn.hwizza.post.vo 
* @fileName : PostReReviewVO.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : REREVIEW 스키마 기반 VO 클래스
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
public class PostReReviewVO extends DefaultVO{
    private int rereview_no;
    private int user_no;
    private int review_no;
    private int like_cnt;

    @NonNull
    private String txt;
}
