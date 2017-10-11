package test.base.structure.lamdba;

import java.util.Arrays;
import java.util.List;
import static java.util.Comparator.comparing;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/2/2722:10
 */
public class TestLamdba {


    public static void testSort(List<Object> list ){
        list.sort(comparing(Object::toString));
    }
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3);
        list.forEach(n-> System.out.println(n));
        int i=2;
        i+=1;
        int b=2;
        b=+2;
        System.out.println(i);
        System.out.println(b);
    }
}
