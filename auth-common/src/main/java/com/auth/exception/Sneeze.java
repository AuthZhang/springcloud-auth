package com.auth.exception;

public class Sneeze extends Annoyance {

    /**
     * 原理：里氏代换原则：能使用父类型的地方一定能使用子类型
     *
     *
     * 结果：
     * a 对象的引用：com.auth.exception.Sneeze
     * Caught Annoyance
     * s 对象的引用：com.auth.exception.Sneeze
     * Caught Sneeze
     * Hello World!
     *
     * 讨论：a对象的地址和s对象的地址是同一个对象
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("a 对象的引用："+a.toString());
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
        catch ( Sneeze s ) {
            System.out.println("s 对象的引用："+s.toString());
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}
