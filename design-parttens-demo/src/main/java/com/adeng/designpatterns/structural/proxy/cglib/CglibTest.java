package com.adeng.designpatterns.structural.proxy.cglib;

public class CglibTest {

    public static void main(String[] args) throws Exception {

        ChaiQuan dog = (ChaiQuan) new CglibProxy().getInstance(ChaiQuan.class);

        dog.run();

        System.out.println("--------------------------");

        System.out.println(dog.hello("hashiqi"));



      /*  //通过反编译工具可以查看源代码

      //com.adeng.designpatterns.structural.proxy.cglib.ChaiQuan$$EnhancerByCGLIB$$b68b430c
        byte [] bytes = ProxyGenerator.generateProxyClass("ChaiQuan$$EnhancerByCGLIB$$b68b430c",
                new Class[]{ChaiQuan.class});
        FileOutputStream os = new FileOutputStream(
                JDKProxyTest.class.getResource("/").getPath()+"ChaiQuan$$EnhancerByCGLIB$$b68b430c.class");
        os.write(bytes);
        os.close();*/


    }
}
