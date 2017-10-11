package test.j2se.address;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by chenfanglin on 2017/8/10.
 */
@Data
@NoArgsConstructor
public class SkuValues implements Serializable{
    private Long svId;
    private String value;
}
