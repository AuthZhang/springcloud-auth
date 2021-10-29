package com.zhangyu.thread.printArraysTwoThreads;

public class NULL {
    public static void  haha(){
        System.out.println("haha");
    }

    public static void  heihei(){
        System.out.println("heihei");
    }

    public void lala(){
        System.out.println("lala");
    }

    public static void main(String[] args) {
        NULL a = ((NULL)null);
        a.haha();
        ((NULL)null).haha();

        NULL b = new NULL();
        b.heihei();
        heihei();
        b.lala();
    }

}


/**
 * @Author zhangyu
 * @Description 同一个文件中非嵌套类(也就是非内部类)，只能有一个类使用public修饰。编译完成后会生成两个文件:NULL.class和A.class
 * @Date 20:43 2021/10/13
 */
 class A{

    public static void main(String[] args) {
        int x=4 ;
        System.out.println("s = " +((x>4) ? 99.9 : 9));
        System.out.println("a + " + (2));

        Integer aa = (Integer)null;
        boolean a = true;
        Integer b = null;
        Integer c = a ? b : 1;
        System.out.println(c);
    }
}

