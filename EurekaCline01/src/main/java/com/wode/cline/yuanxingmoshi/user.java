package com.wode.cline.yuanxingmoshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 85444 on 2018/5/27.
 */
public class user extends prototype{
    private String name;
    private Integer age;
    public List list=new ArrayList();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
