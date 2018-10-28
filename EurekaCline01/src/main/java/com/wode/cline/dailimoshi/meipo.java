package com.wode.cline.dailimoshi;

import com.wode.cline.custom.GPClassLoader;
import com.wode.cline.custom.GPProxy;
import com.wode.cline.custom.GPinvocationHandler;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 85444 on 2018/5/18.
 */
public class meipo implements GPinvocationHandler{
    public person targer;
    public Object instance(person targer){
        this.targer=targer;
        Class cla=targer.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(),cla.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("媒婆开始帮忙找对象,请说出要求");
        method.invoke(targer,args);
        System.out.println("找到对象");
        return null;
    }
}
