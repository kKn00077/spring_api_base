package kr.co.moreturn.hwizza.post.vo;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PostUploadVO {
    private PostVO post;
    private List<PostImageVO> img_list;
    private List<PostStockVO> stock_list;
}
