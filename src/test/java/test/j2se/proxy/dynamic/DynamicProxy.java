package test.j2se.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/2/1818:22
 */
public class DynamicProxy implements InvocationHandler {
    public Object object;

    public DynamicProxy(Object object){
        this.object=object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(object,args);
        return null;
    }
}
