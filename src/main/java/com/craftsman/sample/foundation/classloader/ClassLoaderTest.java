package com.craftsman.sample.foundation.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author chenfanglin
 * @desc 用于测试class loader 加载.用于测试判断两个对象是否在JVM中为同一个对象
 * 1.在JVM中如果为同一个对象需要具备两个条件：类的加载器和类的全限定名完全一致
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader=new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                //1.获取文件名称
                String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
                System.out.println(fileName);
                //2.获取流
                InputStream is=getClass().getResourceAsStream(fileName);
                if(Objects.isNull(is)){
                    return super.loadClass(name);
                }
                try {
                    byte[] bytes=new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name,bytes,0, bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        Class myClass=classLoader.loadClass(ClassLoaderTest.class.getName());
        Object myClassObject=myClass.newInstance();
        System.out.println(myClassObject instanceof ClassLoaderTest);
        System.out.println(ClassLoaderTest.class.getClassLoader().toString());
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent().toString());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().toString());
    }

}
