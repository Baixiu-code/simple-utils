package test.j2se.address;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by chenfanglin on 2017/8/10.
 * @desc 添加商品
 */
@Data
public class AddProductItemDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long skuId;
    private Long outSkuId;
    private BigDecimal salePrice;
    private BigDecimal costPrice;
    private BigDecimal marketPrice;
    private Integer amount;    //库存
    private List<AddProductSpec> specs;//单品规格
}
