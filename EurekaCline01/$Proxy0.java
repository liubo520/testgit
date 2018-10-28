package com.wode.cline.custom;
improt java.lang.reflect.Method
public class $Proxy0 implements java.lang.Class{
GPInvocationHandler h;
public $Proxy0(GPInvocationHandler h){
this.h=h;
}
public void findLove() throws Throwable {
Method m=com.wode.cline.dailimoshi.person.class.getMethod("findLove",new class[]{})
this.h.invoke(this,m,null);
}
}