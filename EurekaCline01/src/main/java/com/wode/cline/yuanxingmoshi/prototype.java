package com.wode.cline.yuanxingmoshi;

import java.util.ArrayList;

/**
 * Created by 85444 on 2018/5/27.
 */
public class prototype implements Cloneable{
    public ArrayList list=new ArrayList();
    protected Object clone() throws CloneNotSupportedException{
        prototype prototype=null;
        try {
            prototype=(prototype) super.clone();
            prototype.list=(ArrayList) list.clone();
        }catch (Exception e){}
        return super.clone();
    }
}
