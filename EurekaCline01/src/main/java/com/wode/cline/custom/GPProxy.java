package com.wode.cline.custom;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import com.sun.org.apache.bcel.internal.util.ClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by 85444 on 2018/5/18.
 * 生产代理对象的代码
 */
public class GPProxy {
    public static String ln="\n";
    public static Object newProxyInstance(GPClassLoader classLoader,
                                          Class<?> [] interfaces,GPinvocationHandler h){
        try {

        //1、生产源代码
        String proxySrc=generateSrc(interfaces[0]);

        //2、将生成的源代码输出到磁盘、保存为.java文件
        //GPProxy.class.getResource("").getPath();
        File file=new File("D:\\EurekaCline01\\src\\main\\java\\com\\wode\\cline\\custom\\$Proxy0.java");
        FileWriter fileWriter=new FileWriter(file);
        fileWriter.write(proxySrc);
        fileWriter.flush();
        fileWriter.close();
        //3、编译源代码，并生成.class文件
            JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager=compiler.getStandardFileManager(null,null,null);
            Iterable iterable=manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task=compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();
        //4、将class文件中的内容，动态加载到jvm中来

        //5、返回被代理后的代理对象
//            Class proxyclass=classLoader.findClass("$Proxy0");
            Class proxyclass=classLoader.findClass("$Proxy0");
            Constructor c=proxyclass.getConstructor(GPinvocationHandler.class);
            file.delete();
            return c.newInstance(h);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private static String generateSrc(Class<?> interfaces){
        StringBuffer str=new StringBuffer();
        str.append("package com.wode.cline.custom;"+ ln);
        str.append("import java.lang.reflect.Method;"+ln);
        str.append("public class $Proxy0 implements "+interfaces.getName()+"{"+ln);
        str.append("GPinvocationHandler h;"+ln);
        str.append("public $Proxy0(GPinvocationHandler h){"+ln);
        str.append("this.h=h;"+ln);
        str.append("}"+ln);
        for (Method m:interfaces.getMethods()){
            str.append("public "+m.getReturnType()+" "+m.getName()+"()  throws Throwable {" +ln);
            str.append("Method m="+interfaces.getName()+".class.getMethod(\""+m.getName()+"\",new Class[]{});"+ln);
            str.append("this.h.invoke(this,m,null);"+ln);
            str.append("}"+ln);
        }
        str.append("}");

        return str.toString();
    }
}
