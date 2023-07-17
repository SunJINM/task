import org.junit.Test;

public class HelloWorld {

    public static void main(String[] args){
        System.out.println("Hello, world");
    }

    @Test
    public void test01(){
        int a1 = 128;
        int a2 = 128;


        Integer b1 = 128;
        Integer b2 = 128;
        System.out.println(a1 == a2);//比较值是否相等
        System.out.println(b1 == b2);//比较的是内存地址是否相等

        System.out.println(a1 == b1);//会对b1先拆箱，取出值后与a1比较
    }


    @Test
    public void test02(){

        Integer a1 = 127;
        Integer a2 = 127;
        System.out.println(a1 == a2);

        // 自动装箱的Byte对象 和 自动装箱的Byte对象 比较，区间[-128, 127]中
        Byte b1 = 127;// 缓存池
        Byte b2 = 127;// 缓存池
        System.out.println("Byte autoBoxing == Byte autoBoxing, 区间[-128, 127]中，result:" + (b1 == b2));// true
        System.out.println("----------------------------------------------------");

// 自动装箱的Short对象 和 自动装箱的Short对象 比较，区间[-128, 127]中
        Short s1 = 127;// 缓存池
        Short s2 = 127;// 缓存池
        System.out.println("Short autoBoxing == Short autoBoxing, 区间[-128, 127]中，result:" + (s1 == s2));// true
        System.out.println("----------------------------------------------------");

// 自动装箱的Long对象 和 自动装箱的Long对象 比较，区间[-128, 127]中
        Long l1 = 127L;// 缓存池
        Long l2 = 127L;// 缓存池
        System.out.println("Long autoBoxing == Long autoBoxing, 区间[-128, 127]中，result:" + (l1 == l2));// true
        System.out.println("----------------------------------------------------");

// 自动装箱的Character对象 和 自动装箱的Character对象 比较，区间[-128, 127]中
        Character c1 = 127;// 缓存池
        Character c2 = 127;// 缓存池
        System.out.println("Character autoBoxing == Character autoBoxing, 区间[-128, 127]中，result:" + (c1 == c2));// true
        System.out.println("----------------------------------------------------");

// 自动装箱的Boolean对象 和 自动装箱的Boolean对象 比较，区间[-128, 127]中
        Boolean bool1 = true;// 缓存池
        Boolean bool2 = true;// 缓存池
        System.out.println("Boolean autoBoxing == Boolean autoBoxing, 区间[true, false]中，result:" + (bool1 == bool2));// true
        System.out.println("----------------------------------------------------");

        Double d1 = 127.0D;
        Double d2 = 127.0D;
        System.out.println("Double autoBoxing == Double autoBoxing, 无区间，result:" + (d1 == d2));// true
    }

    @Test
    public void test03(){
        int[] numbers = {1, 2, 34, 124, 214, 45, 45, 45};
        for(int i = 0;i < numbers.length;i++){
            System.out.println(numbers[i]);
        }
        System.out.println("-----------------------------");
        for(int i : numbers){
            System.out.println(i);
        }
    }

    @Test
    public void test04(){
        String name = "小明";
        switch (name){
            case "小明":
                System.out.println("小明");
                break;
            case "小王":
                System.out.println("小王");
                break;
        }
    }

    @Test
    public void test05(){
        int[] age = new int[1];
        age = new int[]{1};
        int[] age1 = {2,34, 54};
        int[][] ages = new int[1][];

        int [][][] points = new int[1][][];

        age = new int[2];

    }
    @Test
    public void test06(){

        char ch = 'a';
        Character cht = ch;
        System.out.println(Character.isLetter(ch));//true
        System.out.println(Character.isDigit(ch));//false
        System.out.println(Character.isWhitespace(ch));//false
        System.out.println(Character.isUpperCase(ch));//false
        System.out.println(Character.isLowerCase(ch));//true
        System.out.println(cht.isUpperCase('A'));//true
        System.out.println(cht.toString());//a
    }

    @Test
    public void test07(){
        String first = "haha";
        String second = new String("haha");
        String second2 = new String("haha");
        String third = "haha";

        System.out.println(first == second);
        System.out.println(first == third);
        System.out.println(second == second2);

        System.out.println(first.equals(second));
    }

    @Test
    public void test08(){
        String sayHello1="HELLO";          //创建两个字符串
        String sayHello2="hello";
        System.out.println(sayHello1.equals(sayHello2));  //使用equals方法进行严格比较
        System.out.println(sayHello1.equalsIgnoreCase(sayHello2));  //使用equalsIgnoreCase方法忽略大小写进行比较
    }

    @Test
    public void test09(){
        String st = "  aabb  cd  ";
        System.out.println(st.trim());

        System.out.println(st.replace("a", "1"));

        String str = new String("Welcome-to-Runoob");

        System.out.println("- 分隔符返回值 :" );
        for (String retval: str.split("-")){
            System.out.println(retval);
        }

        System.out.println("");
        System.out.println("- 分隔符设置分割份数返回值 :" );
        for (String retval: str.split("-", 2)){
            System.out.println(retval);
        }

        System.out.println("");
        String str2 = new String("www.runoob.com");
        System.out.println("转义字符返回值 :" );
        for (String retval: str2.split("\\.", 3)){
            System.out.println(retval);
        }

        System.out.println("");
        String str3 = new String("acount=? and uu =? or n=?");
        System.out.println("多个分隔符返回值 :" );
        for (String retval: str3.split("and|or")){
            System.out.println(retval);
        }

        String Str = new String("This is text");

        System.out.print("返回值 :" );
        System.out.println(Str.substring(4) );

        System.out.print("返回值 :" );
        System.out.println(Str.substring(4, 10) );

    }



}
