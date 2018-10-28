package com.wode.cline.dailimoshi;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by 85444 on 2018/5/20.
 */
public class test2 extends java.lang.ClassLoader{
    public static void main(String[] args) throws Throwable {
        File classFile=new File("D:\\EurekaCline01\\src\\main\\java\\com\\wode\\cline\\custom\\$Proxy0.class");
        if (classFile.exists()){
            FileInputStream in
                    =null;
            ByteArrayOutputStream outputStream=null;
            try {
                in=new FileInputStream(classFile);
                outputStream=new ByteArrayOutputStream();
                byte[] buff=new byte[1024];
                int len;
                while ((len=in.read(buff))!=-1){
                    outputStream.write(buff,0,len);
                }
                ClassLoader classLoader=new ClassLoader();
                test2 test2=new test2();
                test2.defineClass("com.wode.cline.custom.$Proxy0",outputStream.toByteArray(),0,outputStream.size());
            }catch (Exception e){
                e.printStackTrace();
                try {
                    in.close();
                    outputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
