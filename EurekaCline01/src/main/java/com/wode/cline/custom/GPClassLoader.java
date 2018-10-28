package com.wode.cline.custom;



import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.*;

/**
 * Created by 85444 on 2018/5/18.
 * 代码生成，编译，动态load到JVM中
 */
public class GPClassLoader extends ClassLoader{
    private File baseDir;
    public GPClassLoader(){
      String basePath=GPClassLoader.class.getResource("").getPath();
      this.baseDir=new File(basePath);
      System.out.println(basePath);
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = GPClassLoader.class.getPackage().getName() + "." + name;
        if (baseDir != null) {
            File classFile = new File("D:\\EurekaCline01\\src\\main\\java\\com\\wode\\cline\\custom\\$Proxy0.class");
            if (classFile.exists()) {
                FileInputStream in
                        = null;
                ByteArrayOutputStream outputStream = null;
                try {
                    in = new FileInputStream(classFile);
                    outputStream = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        outputStream.write(buff, 0, len);
                    }
                    test2 test2=new test2();
                    return test2.ass();
                    //test2.defineClass("com.wode.cline.custom.$Proxy0", outputStream.toByteArray(), 0, outputStream.size());
                } catch (Exception e) {
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
            return null;
        }
}
