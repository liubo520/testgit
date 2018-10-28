package com.wode.cline.custom;

import java.lang.reflect.Method;

/**
 * Created by 85444 on 2018/5/18.
 */
public interface GPinvocationHandler {
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable;
}
