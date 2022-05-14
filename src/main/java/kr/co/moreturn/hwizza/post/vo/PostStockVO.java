package kr.co.moreturn.hwizza.post.vo;

import kr.co.moreturn.hwizza.utils.vo.DefaultVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/** 
* @packageName : kr.co.moreturn.hwizza.post.vo 
* @fileName : PostStockVO.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : STOCK 스키마 기반 VO 클래스
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
public class PostStockVO extends DefaultVO{

    // 필수로 받아오는 데이터
    private int post_no;
    
    // 필수로 받아오는 데이터
    private String stock_cd;
}
