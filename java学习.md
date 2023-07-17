# Java学习



## 2023.7.15

JVM   java虚拟机

JRE    java运行环境

JDK   java开发环境

System.out.println("Hello, world");

对象是一个名词，方法是动词

java源文件（源文件.java)可以包含多个类



入口方法：

```
class A {

​	public static void main(String[] args){		

​	}

}
```

.java --javac  源文件名->  .class --java   类名-->  

源文件 --->  字节码文件  -->  机器码

javac程序默认使用的编码是JDK（可能会出现乱码问题）。

`javac -encoding utf-8 源文件名`

**为什么不把java源文件直接编译为机器码？**

Linux平台和Windows平台的机器码不同。

run ones on anyway！



```
jshell> System.out.println("Hello, World");
Hello, World

jshell> System.in.read()
a
$2 ==> 97

jshell> new Scanner(System.in)
$3 ==> java.util.Scanner[delimiters=\p{javaWhitespace}+][position=0][match valid=false][need input=false][source closed=false][skipped=false][group separator=\x{2c}][decimal separator=\x{2e}][positive prefix=][negative prefix=\Q-\E][positive suffix=][negative suffix=][NaN string=\QNaN\E][infinity string=\Q∞\E]

jshell> $3.nextLine()
a
$4 ==> "a"

jshell> $3.nextLine()
ad
$5 ==> "ad"

jshell> var scanner = new Scanner(System.in)
scanner ==> java.util.Scanner[delimiters=\p{javaWhitespace}+] ... \E][infinity string=\Q∞\E]

jshell> scanner.nextLine()
hello
$7 ==> "hello"
```

**var不是关键字**



## 变量

![img](https://img-blog.csdnimg.cn/20210526170534303.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTg5MjI2,size_16,color_FFFFFF,t_70)

**注意：**

**局部变量在使用前必须先声明、初始化（赋初值）再使用**
**成员变量不自行初始化，会自动初始化为该类型的默认初始值**
**静态变量不自行初始化，会自动初始化为该类型的默认初始值**

a~z  97~122

A~Z  65~90

## 字符运算

转义字符

\b  退格

\r  回车

```
var scanner = new Scanner(System.in)
scanner.nextInt();
```

## 数据类型

字符类型：char、String

整数类型：byte、int、short、long

小数类型：float、double

布尔类型：boolean

void



![图片.png](https://cdn.nlark.com/yuque/0/2023/png/1477107/1688657238359-18fcdf54-7ff8-40ec-8d0b-c8ab25c02d92.png?x-oss-process=image%2Fresize%2Cw_669%2Climit_0)

**byte -128  127**

**char、**0 65535****

**short   -32768   32767**

**int  -2147483648 (21亿)     2147483647**

**long   90万亿亿**

long   L

float  F

double D

小数除法  5.0/0 = Inifity

**基本数据类型：修饰的变量代表它所表示的这段内存空间存储的是直接值，其直接存储在内存的内存栈上面，数据本身的值就存储在栈空间里面。**

`int a = 123;`

**包装数据类型：它相当于将基本类型"包装起来"，使它具有了对象的性质**

为什么需要包装数据类型：

比如说我们定义了一个学生类Student，其中有一个属性表示该学生某学科的考试成绩，成绩我们用整型的数据表示。那么这个数据我们用什么数据类型修饰呢？不提及到包装类的情况下，我们用int类型来修饰这个属性，但是你会发现这样不能解决一个特殊的问题，就是你无法表示这个学生该学科没有成绩（规定不用用其他属性标记表示没有成绩）。如果我们用包装类Integer来表示，空值就可以表示没有成绩。

参考链接：https://www.jianshu.com/p/bb629b7ff97c

**装箱**

将基本数据类型转变为包装器类型。

```java
int i = 10;

Integer ii = new Integer(i);

Integer ii = Integer.valueof(i);

Integer ii = i;  //自动装箱
```

**拆箱**

将包装器类型转化为基本数据类型。

```java
Integer i = 10;

int ii = i.intValue();

int ii = i;// 自动拆箱
```

### 缓存池

![image-20230716172521794](C:\Users\DELL\AppData\Roaming\Typora\typora-user-images\image-20230716172521794.png)

对于`==`操作符来说，如果比较的数据是`基本类型`，则比较它们的`值`，如果比较的是`对象`，则会比较`对象的内存地址`。另外，如果一个是基本类型、一个是包装类型，在比较前会先把包装类型`拆箱`成基本类型，然后进行比较。

```java
// 自动装箱的Integer对象 和 自动装箱的Integer对象 比较，区间[-128, 127]之外
Integer i11 = 128;
Integer i12 = 128;
System.out.println("Integer autoBoxing == Integer autoBoxing, 区间[-128, 127]之外，result:" + (i11 == i12));// false
```

```java
// 自动装箱会从缓存池中取对象，缓存池的区间为[-128, 127]
// 自动装箱的Integer对象 和 自动装箱的Integer对象 比较，区间[-128, 127]中
Integer i13 = 127;// 缓存池
Integer i14 = 127;// 缓存池
System.out.println("Integer autoBoxing == Integer autoBoxing, 区间[-128, 127]中，result:" + (i13 == i14));// true

```

参考链接：https://blog.csdn.net/qq_26287435/article/details/107852241



## 操作符

按功能分类

- 算术操作符（+，-，*，/，%，++，--）
- 关系操作符（>，<，>=，<=，= =，!=）
- 布尔逻辑操作符（!，&&，||, |, &）
- 位操作符（>>，<<，>>>，&，|，^，~）
- 赋值操作符（=，及其扩展赋值运算符如+=）
- 条件操作符（?：）
- 其它（包括分量操作符 ·，下标操作符 []，实例操作符  instanceof，内存分配操作符new，强制类型转换操作符 (类型)，方法调用操作符 () 等）



## 流程控制语句

```java
int[] numbers = {1, 2, 34, 124, 214, 45, 45, 45};
        for(int i = 0;i < numbers.length;i++){
            System.out.println(numbers[i]);
        }
        System.out.println("-----------------------------");
        for(int i : numbers){
            System.out.println(i);
        }
```



**注意：**

1. **Java 没有 goto**
2. **switch(对象)中对象的数据类型可以是整数（byte、short、int），char、枚举或字符串[JDK7新增]**



## 数组

创建数组时，必须指定数组长度

```java
int[][][] points = new int[2][][];

// 可以为每一维再指定不同的长度
points[0] = new int[2][3]; 
points[1] = new int[1][2];

// ERROR，多维数组定义时必须至少指定第一维的长度
// int[][][] points2 = new int[][2][]; 

// ERROR，在没有明确前一维的长度时，不能定义下一维的长度 
// int[][][] points3 = new int[2][][2];  

// 指定所有维度的长度
int[][][] points4 = new int[2][2][3];
```

**注**：Java中**声明**数组时不能指定长度(数组中元素的个数)， 例如`int a[5];`是非法的。



### 初始化

**静态初始化**： 数组变量的初始化和数组元素的赋值操作**同时进行**称为静态初始化，本质是用静态数据为数组初始化，此时数组的长度由静态数据的个数决定。

```java
int[] arr = new int[]{1,2,3,4,5};
//或者
int[] arr;
arr = new int[]{1,2,3,4,5};

int[] arr = {1, 2, 3, 4, 5};
```

**动态初始化**： 数组变量的初始化和数组元素的赋值操作**分开进行**称为动态初始化。动态初始化中只确定了元素的个数，而元素值此时只是默认值，真正的数据需要后面单独一个个赋值。

```java
int[] arr = new int[5];
//或者
int[] arr;
arr = new int[5];
```

数组是引用类型，当使用动态初始化方式创建数组时，元素值只是默认值。

对于基本数据类型，默认初始化值各有不同，对于**引用数据类型，默认初始化值为null**。

参考：[Java数组详解 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/615410851)



## 字符&字符串

**注意**：Character类是不可变的，所以一旦一个Character对象被创建，就不能被改变，下面列出了Character类中最有用的一些方法。

![image-20230716182910184](C:\Users\DELL\AppData\Roaming\Typora\typora-user-images\image-20230716182910184.png)


```java
char ch = 'a';
Character cht = ch;
System.out.println(Character.isLetter(ch));//true
System.out.println(Character.isDigit(ch));//false
System.out.println(Character.isWhitespace(ch));//false
System.out.println(Character.isUpperCase(ch));//false
System.out.println(Character.isLowerCase(ch));//true
System.out.println(cht.isUpperCase('A'));//true
System.out.println(cht.toString());//a
```



在Java中，字符串被当作对象来处理。最基本的存储方式是顺序存储方式和链接存储方式。



### 字符串赋值

```java
// 用null赋值
String stringVar = null;

// 用字符串常量直接给字符串赋值
String stringVar2 = "haha";

// 使用new String()初始化字符串
String stringVar3 = new String("haha"); 
String stringVar4 = stringVar3;
```



![img](https://img-blog.csdn.net/20180517115438738)

1）对于String s1=new String（"abc"）语句与String s2=new String（"abc"）语句，存在两个引用对象s1、s2，两个内容相同的字符串对象"abc"，**它们在内存中的地址是不同的**。只要用到new总会生成新的对象。
2）对于String s1="abc"语句与String s2="abc"语句，在JVM中存在着一个**字符串池**，其中保存着很多String对象，并且可以被共享使用，s1、s2引用的是同一个常量池中的对象。由于String的实现采用了Flyweight的设计模式，当创建一个字符串常量时，例如String s="abc"，会首先在字符串常量池中查找是否已经有相同的字符串被定义，其判断依据是String类equals（Object obj）方法的返回值。若已经定义，则直接获取对其的引用，此时不需要创建新的对象；若没有定义，则首先创建这个对象，然后把它加入到字符串池中，再将它的引用返回。由于String是不可变类，一旦创建好了就不能被修改，因此String对象可以被共享而且不会导致程序的混乱。

```java
String s1="abc"；　//在常量区里面存放了一个"abc"字符串对象
String s2="abc"；　//s2引用常量区中的对象，因此不会创建新的对象
String s3=new String（"abc"）　//在堆中创建新的对象
String s4=new String（"abc"）　//在堆中又创建一个新的对象
```



**引申**：

**对于String类型的变量s，赋值语句s=null与s=“”是否相同？**

对于赋值语句s=null，其中s是一个字符串类型的引用，它不指向任何一个字符串。而赋值语句s=“ ”中的s是一个字符串类型的引用，它指向另外一个字符串（这个字符串的值为“”，即空字符串），因此，这两者是不同的。



> **new String（"abc"）创建了几个对象？**
> 一个或两个。如果常量池中原来有"abc"，那么只创建一个对象；如果常量池中原来没有字符串"abc"，那么就会创建两个对象。

参考链接：https://blog.csdn.net/pengzhisen123/article/details/79515065





**字符串连接**

```java
string1.concat(string2);
```

concat()方法返回一个字符串，是将字符串string2添加到string1后面之后形成新字符串。

连接字符串还可以使用加号“+”运算符。这是一个重载了的运算符，用来直观地连接两个字符串，它使用起来比concat()方法更加灵活。



**字符串常用方法**

length()、trim(), replace(String, String), split(String), startsWith(String), substring(int), substring(int, int)

```java
String1.equals(String2);            //严格比较字符串是否相同
String1.equalsIgnoreCase(String2);  //忽略字母大小写来进行比较


public void test08(){
        String sayHello1="HELLO";          //创建两个字符串
        String sayHello2="hello";
        System.out.println(sayHello1.equals(sayHello2));  //使用equals方法进行严格比较
        System.out.println(sayHello1.equalsIgnoreCase(sayHello2));  //使用equalsIgnoreCase方法忽略大小写进行比较
    }
```



trim() 方法用于删除字符串的头尾空白符，空白符包括：空格、制表符 tab、换行符等其他空白符等。

trim() 方法不会改变原始字符串。

trim() 方法不适用于 null, undefined, Number 类型。

```java
String st = "  aabb  cd  ";
st.trim();//aabb  cd
st.replace("a", "1");//11bb  cd
```



split() 方法根据匹配给定的正则表达式来拆分字符串。

**注意：** **.** 、 **$**、 **|** 和 ***** 等转义字符，必须得加 **\\**。

**注意：**多个分隔符，可以用 **|** 作为连字符。

**参数:**

- **regex** -- 正则表达式分隔符。
- **limit** -- 分割的份数。

**返回值：**字符串数组



```java
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
```



```
- 分隔符返回值 :
Welcome
to
Runoob

- 分隔符设置分割份数返回值 :
Welcome
to-Runoob

转义字符返回值 :
www
runoob
com

多个分隔符返回值 :
acount=? 
 uu =? 
 n=?

```



startsWith()方法一般用于检测某请求字符串是否以指定的前缀开始的。例如：服务器要判断某个请求是否合规，首先确定协议，比如http、ftp等，这时，就可以用startsWith()。

endsWith() ，用来判断字符串结尾的后缀。该方法判断字符串是否以指定的后缀结尾。比如，文件扩展名的规范。

```java
public boolean startsWith(String prefix, int toffset)

或

public boolean startsWith(String prefix)
```

**参数**

- **prefix** -- 前缀。
- **toffset** -- 字符串中开始查找的位置。

**返回值**

如果字符串以指定的前缀开始，则返回 true；否则返回 false。



```java
public String substring(int beginIndex)

或

public String substring(int beginIndex, int endIndex)

```



**参数**

- **beginIndex** -- 起始索引（包括）, 索引从 0 开始。
- **endIndex** -- 结束索引（不包括）。

**返回值**

子字符串



```java
String Str = new String("This is text");

System.out.print("返回值 :" );
System.out.println(Str.substring(4) );

System.out.print("返回值 :" );
System.out.println(Str.substring(4, 10) );
```



```
返回值 : is text
返回值 : is te
```



**拓展：**

String、StringBuffer、StringBuilder的区别：

![image-20230716192602002](C:\Users\DELL\AppData\Roaming\Typora\typora-user-images\image-20230716192602002.png)

![image-20230716192626007](C:\Users\DELL\AppData\Roaming\Typora\typora-user-images\image-20230716192626007.png)



1、String类型的字符串对象是不可变的，一旦String对象创建后，包含在这个对象中的字符系列是不可以改变的，直到这个对象被销毁。

2、StringBuilder和StringBuffer类型的字符串是可变的，不同的是StringBuffer类型的是线程安全的，而StringBuilder不是线程安全的

3、如果是多线程环境下涉及到共享变量的插入和删除操作，StringBuffer则是首选。如果是非多线程操作并且有大量的字符串拼接，插入，删除操作则StringBuilder是首选。



javadoc

`javadoc -author -version Test.java`

`javadoc -encoding UTF-8 -charset UTF-8 Test.java `解决编码问题



## 2023.7.17面向对象

### 1 类的组成

类由成员变量和成员方法组成。

#### 1.1 成员变量

静态变量：也叫类变量，有static关键词修饰。

实例变量：没有static修饰。

**区别**

①不同对象的实例变量互不相同，也就是说分配给不同对象的实例变量占有不同的内存空间，改变其中一个对象的实例变量不会影响其他对象的实例变量。

②所有对象共享类变量，即分配给这些对象的这个类变量占有相同的一处内存，改变其中一个对象的这个类变量会影响其他对象的这个类变量。

③类变量是属于该类的，在类被加载到内存时就为类变量分配了相应的内存空间，故，可通过类名直接访问类变量。

```java
class Factory {
    int value = 0;
    int limit = 0;
    static int step = 2;    //step为类变量
    
    void increat(){
        value++;
        if(value == limit){
            value = 0;
        }
    }
    
    int getValue(){
        int i;
        return value;
    }
}
public class Lei {
    public static void main(String[] args) {
        //声明两个对象d1，d2
        Factory d1 = new Factory();
        Factory d2 = new Factory();
        System.out.println(d1.getValue());//输出结果为0
        System.out.println(d2.getValue());//输出结果为0
        System.out.println(d1.step);//输出结果为2
        System.out.println(d2.step);//输出结果为2
        d1.increat();//对d1进行了++
        d1.step = 3;//对d1的step进行了赋值
        System.out.println(d1.getValue());//d1的值变成了1
        System.out.println(d2.getValue());//d2的值没有变，依然为0
        System.out.println(d1.step);//d1.step的值变成了3
        System.out.println(d2.step);//d2.step的值也变成了3！
        //这也就说明了，一个对象里的类变量改变，其他对象里的对应的类变量也会改变
 
        //对于类变量，可以直接用类名来访问而不用创建对象
        Factory.step = 5;
        System.out.println(Factory.step);
    }
}
```

#### 1.2 成员方法

**静态方法**

静态方法与它们所在的类相关联，即调用它们时无需创建类的实例，即ClassName.methodName(args)。
它们的设计目的是在从同一类创建的所有对象之间共享。
静态方法不能被覆盖，因为它们是由编译器在编译时使用静态绑定解析的。但是，我们可以在超类和子类中将同名方法声明为静态，但它会被称为方法隐藏，因为派生类方法将隐藏基类方法。

**实例方法**

- 实例方法属于类的对象，而不属于类，即它们可以在创建类的对象后调用。
- 实例方法不是在每个实例的基础上存储的，即使使用虚拟方法也是如此。它们存储在一个单独的内存位置，它们只“知道”它们属于哪个对象，因为在调用它们时会传递这个指针。
- 它们可以被覆盖，因为它们是在运行时使用**动态绑定**解析的。

**实例方法 VS 静态方法**

- 实例方法可以直接访问实例方法和实例变量。
- 实例方法可以直接访问静态变量和静态方法。
- 静态方法可以直接访问静态变量和静态方法。
- 静态方法不能直接访问实例方法和实例变量。他们必须使用对对象的引用。并且静态方法不能使用**this**关键字，因为没有引用 'this' 的实例。

#### 1.3 构造函数

构造函数、构造器

作用：对对象进行初始化

- 通过构造器创建对象（实例）
- 构造器是用于初始化实例的一组指令
- 在构造方法执行之后才完成对象的创建
- 可以向构造器传递参数
- 构造器的名称必须与类名一致
- 修饰符只有访问控制修饰符
- 构造器不能定义返回值
- 类可以定义多个构造器，至少有一个构造器
- 如果类中未编写任何构造器，则会包含一个默认的构造器
- 添加任何构造器都会失去默认构造器

**注意：**

**方法名可以与构造函数重名。**

**不能用default修饰构造函数**

```java
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
```

**扩展：**构造代码块，给所有对象进行初始化。

#### 1.4 this关键字

this 关键字是 [Java](http://c.biancheng.net/java/) 常用的关键字，可用于任何实例方法内指向当前对象，也可指向对其调用当前方法的对象，或者在需要当前类型对象引用时使用。

**this.属性名**

大部分时候，普通方法访问其他方法、成员变量时无须使用 this 前缀，但如果方法里有个局部变量和成员变量同名，但程序又需要在该方法里访问这个被覆盖的成员变量，则必须使用 this 前缀。



**this.方法名**

this 关键字最大的作用就是让类中一个方法，访问该类里的另一个方法或实例变量。

大部分时候，一个方法访问该类中定义的其他方法、成员变量时加不加 this 前缀的效果是完全一样的。

**注意：**对于 static 修饰的方法而言，可以使用类来直接调用该方法，如果在 static 修饰的方法中使用 this 关键字，则这个关键字就无法指向合适的对象。所以，static 修饰的方法中不能使用 this 引用。并且 Java 语法规定，静态成员不能直接访问非静态成员。



**this()访问构造方法**

注意：

- this( ) 不能在普通方法中使用，只能写在构造方法中。
- 在构造方法中使用时，必须是第一条语句且只能有一条语句。

```java
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

```



#### 1.5 访问控制权限



Java中四种访问权限，从小到大排列：`private` < `default` < `protected` < `public`

![image-20230716221630063](C:\Users\DELL\AppData\Roaming\Typora\typora-user-images\image-20230716221630063.png)

### 2 继承

使用extends关键字。

**说明：**

1. 被继承的类（上例中的 Human）通常被叫做`超类（Super class）`、`基类（Base class）`或`父类（Parent class）`
2. 继承的类（上例中的 Man、Woman）通常被叫做`继承类（Derived class）`或`子类（Sub class）`
3. Java 是单继承
4. 类 `java.lang.Object` 是所有类的根
5. 继承类将拥有（不一定可以访问所有）超类的所有变量和方法
6. 继承类和超类之间应该存在一种 `is-a` 关系，即继承类是超类的一种
7. **构造器不能被继承！！**
8. 不要过度使用继承，特别是不要仅仅为使用超类的某些方法或数据而使用继承；在复用类时优先考虑组合，后考虑继承



构造函数和类同名，父类和子类肯定不同名，那父类的构造函数放在在子类里有什么用啊，那不成一般方法了吗？

因为如果子类继承了父类的构造方法，父类的构造在子类中不符合构造方法的规则，也不符合一般方法的规则。父类的构造在子类中没有返回类型，方法名也与子类的类名不相同。不符合java语法规范。

### 3 类型转换

**从子类向父类的转换称为向上转换**，在需要使用子类对象的时候，通过把变量定义为父类型，我们可以通过一个变量，使用该父类型的所有子类型实例；

**从父类型向子类型的转换称为向下转换**，将父类型变量转换成子类型变量，使用一些通过子类型才能够使用的方法。

向上转换，从父类派生出的子类，我们都能理解为，子类总是父类的一个实例。因此，***\*从子类向父类的转换不需要什么限制，只需直接将子类实例赋值给父类变量即可\****，这也是Java中的多态的实现机制。

**为什么要向下转换？**

在继承关系中，有一些方法是***\*不适合由父类定义\****并由**子类继承并重写的**，有些方法是子类特有的，***\*不应该通过继承得到，且子类可能也会有自己特有的成员变量\****，那么在使用多态机制的时候，若我们要***\*通过父类型变量使用到这些子类特有的方法和属性的话\****，就需要将***\*父类型变量转换成对应的子类型变量\****。

**例如：**

标准库中的数据类型包装类：Integer类，Double类，Long类等，它们都继承自Number类，且它们都有一个方法叫做compareTo用于比较两个同样的类型。然而这个方法是这些子类通过实现Comparable接口来实现的，在Number类中并没有该方法的实现，因此若要通过Number类型变量来使用compareTo方法，就要先将Number类转换成子类的对象。



***\*父类变量向子类转换必须通过显式强制类型转换\****,采取和向上转换相同的直接赋值方式是不行的，；并且，当把一个父类型变量实例转换为子类型变量时，必须确保**该父类变量是子类的一个实例**。

可通过instanceof运算符来判断父类变量是否是该子类的一个实例。

```java
//Man man = (Man) new Human("man"); ClassCastException
//父类必须是该子类的实例
//Human man = new Woman();错误,编译通过，运行报错
Human human = new Man();
Man man = (Man) human;

Woman woman = null;
if(human instanceof Woman)
    woman = (Woman) human;
```

