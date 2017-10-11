package test.base.structure;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/2/2316:30
 */
public class TestArray {
    public static void main(String[] args) {
        String[] strings=new String[]{"1","2","3"};
        System.out.println(strings[0]);
        for(String str:strings){
            if("1".equals(str)){
                System.out.println("oyeah,find it !");
            }
        }
    }
}
