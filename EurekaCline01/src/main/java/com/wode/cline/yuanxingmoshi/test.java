package com.wode.cline.yuanxingmoshi;

/**
 * Created by 85444 on 2018/5/27.
 */
public class test {
    public static void main(String[] args) throws CloneNotSupportedException {
        user user=new user();
        user.setAge(10);
        user.setName("haha");
        user user1=(user) user.clone();
        System.out.println(user.clone());
        System.out.println(user.clone());
    }
}
