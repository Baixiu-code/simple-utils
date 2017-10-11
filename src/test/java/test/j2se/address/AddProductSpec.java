package test.j2se.address;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenfanglin on 2017/8/10.
 * @desc 添加商品
 */
@Data
@NoArgsConstructor
public class AddProductSpec implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long categoryId;        //类别Id
    private Long sid;               //规格Id
    private String specName;        //规格名称
    private Integer isRequired;     //是否必填
    private Integer isCustom;       //是否自定义
    private Integer seq;            //顺序值
    private Integer isExist;        //是否删除 0:删除 1:不删除
    private List<SkuValues> specValue;
}
