package test.j2se.proxy.dynamic;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/2/1818:20
 */
public class Boss implements Hello{
    @Override
    public void sayHello(String helloContent) {
        System.out.println("boss"+helloContent);
    }
}
