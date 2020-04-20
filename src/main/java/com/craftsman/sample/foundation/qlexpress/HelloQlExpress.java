package com.craftsman.sample.foundation.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

/**
 * @author baixiu
 * @date 2019-09-27
 */
public class HelloQlExpress {

    public static void main(String[] args) throws Exception{
        ExpressRunner runner=new ExpressRunner();
        DefaultContext<String,Object> context=new DefaultContext<>();
        context.put("a",1);
        context.put("b",2);
        context.put("c",3);
        String express="a+b*c";
        Object result=runner.execute(express,context,null,true,false);
        System.out.println(result);
    }
}
