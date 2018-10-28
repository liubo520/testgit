package com.wode.cline.dailimoshi;


import com.wode.cline.custom.GPinvocationHandler;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by 85444 on 2018/5/18.
 */
public class test {
    public static void main(String[] args) throws Throwable {
        person per=(person) new meipo().instance(new xiaoxingxing());
        per.findLove();

//        byte[] date=ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{person.class});
//        FileOutputStream os=new FileOutputStream("b.class");
//        os.write(date);
//        os.close();
    }
}
