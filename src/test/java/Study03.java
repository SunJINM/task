import org.junit.Test;

public class Study03 {

    /**
     *  测试抽象类中的成员
     */
    @Test
    public void test01() {
        Test01Class test01Class = new Test01Class();
        test01Class.soo();
        Test01AbsClass.soo();
        test01Class.doo();
    }

    /**
     *  查看父类中的静态方法能否被子类重写，结论：不能
     */
    @Test
    public void test02() {
        Son son = new Son();
        son.printA();
        son.printB();
        son.printC();
        System.out.println("-----------");
        Parent parent = new Son();
        parent.printA();
        parent.printB();
    }

    /**
     *  final 修饰的静态变量和实例变量初始化
     *  查看静态代码块和动态代码块
     */
    @Test
    public void test03() {
        new Test04Class();
        new Test04Class();
    }

    @Test
    public void test04() {
        Tool.isStringEquals();
        //Tool tool = new Tool();
    }

    /**
     *  接口测试
     */
    @Test
    public void test05() {
        Test05Class test05Class = new Test05Class();
        test05Class.aoo();
        test05Class.boo();
        test05Class.coo();
        //接口中的静态方法只能通过接口名调用
        Test05Inter1.soo();
    }

    /**
     *  静态内部类
     */
    @Test
    public void test06() {
        OutClass.InnerClass innerClass = new OutClass.InnerClass();
        innerClass.fun2();
        OutClass.InnerClass.fun1();
    }

    /**
     *  成员内部类
     */
    @Test
    public void test07() {
        Circle.Draw draw = new Circle(1).new Draw();
        draw.drawCircle();
    }

    /**
     *  本地内部类
     */
    @Test
    public void test08() {
        Test06Class test06Class = new Test06Class();
        test06Class.test();
    }

    /**
     *  匿名内部类
     */
    Test07Inter t = new Test07Inter() {
        @Override
        public void fun() {
            System.out.println("hello");
        }
    };
    @Test
    public void test09() {
        t.fun();
    }
}

/**
 *  测试抽象类的成员
 */

abstract class Test01AbsClass {


    int a = 10;
    private int b = 10;
    protected int c = 10;
    public int d = 10;
    static int E = 10;

    Test01AbsClass() {
        System.out.println("构造函数");
    }

    abstract void aoo();

    public abstract void poo();

   // private abstract void coo();
    protected abstract void doo();

    void boo(){
        System.out.println("boo");
    }

    private void eoo() {
        System.out.println("eoo");
    }

    static void soo() {
        System.out.println("soo");
    }

}

class Test01Class extends Test01AbsClass {

    @Override
    void aoo() {
        System.out.println("abstract aoo()");
    }

    @Override
    public void poo() {
        System.out.println("abstract public poo()");
    }

    @Override
    protected void doo() {
        System.out.println("protected abstract doo()");
    }
}

/**
 *  测试父类中的静态方法是否可以被子类重写
 */

class Parent {
   public static void printA() {
       System.out.println("父类静态方法A");
   }
   public void printB() {
       System.out.println("父类普通方法B");
   }

   public static void printC() {
       System.out.println("父类静态方法C");
   }
}

class Son extends Parent{
    public static void printA() {
        System.out.println("子类静态方法A");
    }

    public void printB() {
        System.out.println("子类普通方法B");
    }

}

/**
 *  final 关键字测试
 */

class Test03ExtClass {
    public final void foo() {
        System.out.println("foo()");
    }
}

class Test03Class extends Test03ExtClass {
//    public final void foo() {
//
//    }
}

/**
 *  final 修饰变量测试
 */

class Test04Class {
    final static int AGE;
    final int ID;

    //在构造函数中初始化final修饰的实例变量
    Test04Class() {
        ID = 12;
    }

    //在静态块中初始化
    static {
        System.out.println("static block called");
        AGE = 10;
    }

    //动态代码块中初始化
    {
        System.out.println("dynamic block called");
        //ID = 12;
    }
}

/**
 *  工具类
 */

final class Tool {
    private Tool() {
        //do nothing
    }
    public static boolean isStringEquals(){
        return true;
    }
}

/**
 *  接口
 */

interface Test05Inter1 {
    int one = 1;

    void aoo();

    default void boo() {
        System.out.println("Test05Inter1 boo()");
    }

    static void soo() {
        System.out.println("static soo()");
    }
}
interface Test05Inter2 {
    default void boo() {
        System.out.println("Test05Inter2 boo()");
    }
    void coo();
}
class Test05Class implements Test05Inter1, Test05Inter2 {

    @Override
    public void aoo() {
        System.out.println("实现aoo()");
    }
    public void boo() {
        System.out.println("重写boo()");
    }
    @Override
    public void coo() {
        System.out.println("实现coo()");
    }
}

interface Test05Inter extends Test05Inter1, Test05Inter2 {
    void aoo();

    @Override
    default void boo() {
        Test05Inter1.super.boo();
    }

    @Override
    void coo();
}

/**
 *  内部类
 */

class OutClass {
    public static int s = 1;
    public int b = 1;

    public static class InnerClass {

        static String test = "test";
        int a = 1;
        static void fun1() {
            System.out.println(s);
            //System.out.println(b);
            //System.out.println(a);
        }
        void fun2() {
            System.out.println(test);
            //System.out.println(b);
        }
    }
}

class Circle {
    private double radius = 0.0;
    public static int count = 1;
    public Circle(double radius) {
        this.radius = radius;
    }

    public class Draw {
        public void drawCircle() {
            System.out.println(radius);
            System.out.println(count);
        }
    }
}

class Test06Class {


    public void test() {
        class InnerClass1 {
            private String name;
            final static String test = "1";
            public InnerClass1(String name) {
                super();
                this.name = name;
            }
            public void say(String str) {
                System.out.println(name + ":"+str);
            }
        }
        new InnerClass1("test").say("hello");
    }
}

interface Test07Inter {
    void fun();
}

/**
 *  Java Bean
 */

class JavaBean {
    private String name;
    private int age;

    private boolean success;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}













