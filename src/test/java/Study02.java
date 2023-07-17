import org.junit.Test;

public class Study02 {

    public static void main(String[] args){
        Student.getStd();

        Teacher teacher = new Teacher();
        teacher.Teacher();

    }

    /**
     *  类型转换测试 子类向父类转换
     */
    @Test
    public void test01(){
        Human man = new Man();
        Human woman = new Woman();
    }

    /**
     *  父类向子类转换
     */

    @Test
    public void test02() {
       //Man man = (Man) new Human("man"); ClassCastException
        //父类必须是该子类的实例
        //Human man = new Woman();错误
        Human man = new Man();
        Man man1 = (Man) man;
    }

    /**
     *  作业
     */
    @Test
    public void test03() {
        Human human = new Man();
        Human human1 = new Woman();
        ClassCast(human1);
    }
    public void ClassCast(Human human) {
        Man man = null;
        if(human instanceof Man){
            man = (Man) human;
            System.out.println("man");
        }else{
            System.out.println("woman");
        }
    }
}


/**
 *  测试静态成员和实例成员
 */
class Student {
    public String name;
    static int age;

    static void getStd(){
        System.out.println(age);
    //    System.out.println(name); ERROR
    }
}

/**
 *  构造函数，不能使用default修饰构造函数
 */

class Teacher {

    public String name;

    Teacher(){
        System.out.println("Teacher()构造函数");
    }

    //不能使用default修饰构造函数
    public Teacher(String name){
        this.name = name;
    }

    //方法名可以与构造函数重名
    void Teacher(){
        System.out.println("hello");
    }
}

/**
 *  this关键字测试
 */
class TestThis {
    int a;
    int b;

    TestThis(int a){
        this.a = a;
    }
    TestThis(int a, int b){
        this(a);
        //this();ERROR
        this.b = b;
       // this(a);
    }
}

class Human {
    private String name;
    Human(String name){
        this.name = name;
    }
}

class Man extends Human {

    public Man(){
        super("man");
    }
}

class Woman extends Human {
    public Woman(){
        super("woman");
    }

}











