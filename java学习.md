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

<<<<<<< HEAD
**char、short   -32768   32767**
=======
**char、**0 65535****

**short   -32768   32767**
>>>>>>> 72c7bfb9ca6e7240b707f3ea99b20ba46e9112d4

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



<<<<<<< HEAD
=======
## 2023.7.17面向对象

### 1 类的组成

类由成员变量和成员方法组成。

#### 1.1 成员变量

静态变量：也叫类变量，有static关键词修饰。

实例变量：没有static修饰。

**区别**

①不同对象的实例变量互不相同，也就是说分配给不同对象的实例变量占有不同的内存空间，改变其中一个对象的实例变量不会影响其他对象的实例变量。

②所有对象共享静态变量，即分配给这些对象的这个静态变量占有相同的一处内存，改变其中一个对象的这个静态变量会影响其他对象的这个静态变量。

③静态变量是属于该类的，在类被加载到内存时就为静态变量分配了相应的内存空间，故，可通过类名直接访问静态变量。

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
静态方法不能被覆盖，因为它们是由编译器在编译时使用静态绑定解析的。但是，我们可以在父类和子类中将同名方法声明为静态，但它会被称为方法隐藏，因为派生类方法将隐藏基类方法。

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

**访问控制修饰符，default是指不写修饰符**

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



构造函数和类同名，父类和子类肯定不同名，那父类的构造函数放在在子类里没有什么用

因为如果子类继承了父类的构造方法，父类的构造在子类中不符合构造方法的规则，也不符合一般方法的规则。父类的构造在子类中没有返回类型，方法名也与子类的类名不相同。不符合java语法规范。

### 3 类型转换

**从子类向父类的转换称为向上转换**，在需要使用子类对象的时候，通过把变量定义为父类型，我们可以通过一个变量，使用该父类型的所有子类型实例；

**从父类型向子类型的转换称为向下转换**，将父类型变量转换成子类型变量，使用一些通过子类型才能够使用的方法。

向上转换，从父类派生出的子类，我们都能理解为，子类总是父类的一个实例。因此，***从子类向父类的转换不需要什么限制，只需直接将子类实例赋值给父类变量即可***，这也是Java中的多态的实现机制。

**为什么要向下转换？**

在继承关系中，有一些方法是***不适合由父类定义***并由**子类继承并重写的**，有些方法是子类特有的，***不应该通过继承得到，且子类可能也会有自己特有的成员变量***，那么在使用多态机制的时候，若我们要***通过父类型变量使用到这些子类特有的方法和属性的话***，就需要将***父类型变量转换成对应的子类型变量***。

**例如：**

标准库中的数据类型包装类：Integer类，Double类，Long类等，它们都继承自Number类，且它们都有一个方法叫做compareTo用于比较两个同样的类型。然而这个方法是这些子类通过实现Comparable接口来实现的，在Number类中并没有该方法的实现，因此若要通过Number类型变量来使用compareTo方法，就要先将Number类转换成子类的对象。



***父类变量向子类转换必须通过显式强制类型转换***,采取和向上转换相同的直接赋值方式是不行的；并且，当把一个父类型变量实例转换为子类型变量时，必须确保**该父类变量是子类的一个实例**。

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





### **扩展**

JUnit

```java
import org.junit.*;

public class JunitFlowTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("before...");
    }
    @After
    public void tearDown() {
        System.out.println("after");
    }

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("beforeClass...");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("afterClass...");
    }
    @Test
    public void test1() {
        System.out.println("test1方法...");
    }

    @Test
    public void test2() {
        System.out.println("test2方法...");
    }
}
```

```
beforeClass...
before...
test1方法...
after
before...
test2方法...
after
afterClass...
```





### 4 抽象类&抽象方法

abstract 类是抽象类，abstract方法是抽象方法。

**抽象类与抽象方法的总结**

- 抽象类和抽象方法的产生是为了维护继承链的逻辑，即抽象类相对于那些普通的类处于继承树的根部。

- 抽象方法的产生完全是为了迎合抽象类的存在：抽象方法只能写在抽象类中！
- 抽象类的字段（反正也没有abstract抽象字段一说）只要像正常的继承关系那样使用就好了。
- 被abstract关键字修饰的类叫抽象类。
- 被abstract关键字修饰的方法叫抽象方法

**注意：**

1、抽象类（abstract class）不能被实例化！！
2、抽象类是有构造器的（所有类都有构造器）
3、抽象类以有抽象方法，也可以没有抽象方法；但是抽象方法只能存在于抽象类中。
4、抽象类中的非抽象方法如同在非抽象类中一样，正常继承使用。
5、抽象方法（abstract method）只能存在于抽象类中！！
6、抽象方法所在的类，一定是抽象类（因为抽象方法是没有方法体的，如果所在的类不是抽象类，那么该类可以实例化对象，调用抽象方法，然后无方法体去具体实现功能，则矛盾）
7、不存在所谓的抽象静态方法

8、抽象类可以有成员变量、普通方法和静态方法

#### 4.1 抽象方法

只有方法的声明，没有方法体，即没有{}，以分号 ; 结尾，使用 abstract 关键字修饰。

**抽象方法不能用private、final、static、native修饰。**

#### 4.2 抽象类

抽象类不能实例化，不能直接创建对象。抽象类是用来被继承的，**继承抽象类的子类必须重写父类所有的抽象方法**。否则，该子类也必须声明为抽象类，使用 abstract 关键字修饰。

抽象类也是类，因此原来类中可以有的成员，抽象类都可以有，那么抽象类不能直接创建对象，为什么还有构造器呢？供子类调用，子类创建对象时，需要为从父类继承的属性初始化。

抽象类不能使用final修饰。


```java
public class test {

    @Test
    public void test1() {
        Children children = new Children();
        children.eat();
        Person.sleep();
    }
}


abstract class Person {
    abstract void run();
    abstract void walk();

    void eat(){
        System.out.println("eat");
    }

    static void sleep() {
        System.out.println("sleep");
    }
}

class Children extends Person {
    void run(){
        System.out.println("run");
    }
    void walk(){
        System.out.println("walk");
    }

}

```

#### 4.3 abstract关键字

1、可以用来修饰的结构：类、方法，不能用来修饰变量、代码块、构造器。

2、不能和 abstract 一起使用的修饰符：

外部类可用修饰符：abstract、final ，两种访问修饰符：public和缺省。其中abstract和final不能一起修饰类。
方法可用修饰符：4种访问修饰符，static、final、abstract、native。不能共存的：native，abstract不行 因为都没有方法体，不知道是什么情况，会有歧义

- abstract final 不能同时用来修饰类
- abstract final 不能同时用来修饰方法
- static abstract 不允许。因为抽象方法的调用需要使用方法的动态绑定机制，因此静态方法不能是抽象方法
- private abstract 不允许。因为抽象方法必须要被继承类覆写，因此继承类必须能够访问抽象方法，所以抽象方法的访问权限不能是 private
- 给 abstract 方法赋 default 访问权限，编译允许，但不推荐。因为这样会造成其他包（package）的类无法继承这个抽象类，因为这个抽象方法对其他包（package）的类不可见

### 5 final

final在Java中是一个保留的关键字，可以声明成员变量、方法、类以及本地变量。

凡是对成员变量或者本地变量(在方法中的或者代码块中的变量称为本地变量)声明为final的都叫作final变量。final变量经常和static关键字一起使用，作为常量。
final变量是只读的。

方法前面加上final关键字，代表这个方法不可以被子类的方法重写。final方法比非final方法要快，因为在编译的时候已经静态绑定了，不需要在运行时再动态绑定。

使用final来修饰的类叫作final类。final类通常功能是完整的，它们不能被继承。Java中有许多类是final的，譬如String, Interger以及其他包装类。

- 用 final 修饰成员变量时表示该变量是一个常量，在初始化后不能被改变 

- 使用 final 关键字修饰类的静态变量，须在定义时或者在静态块中进行初始化

- 使用 final 关键字修饰类的实例变量，可以在动态块中、也可以在每个构造函数中进行初始化

**关于final的重要知识点：**

1. final关键字可以用于成员变量、本地变量、方法以及类。

2. final成员变量必须在声明的时候初始化或者在构造器中初始化，否则就会报编译错误。

3. 你不能够对final变量再次赋值。

4. 本地变量必须在声明时赋值。

5. 在匿名类中所有变量都必须是final变量。

6. final方法不能被重写。

7. final类不能被继承。

8. 接口中声明的所有变量本身是final的。

9. final和abstract这两个关键字是反相关的，final类就不可能是abstract的。

10. final方法在编译阶段绑定，称为静态绑定(static binding)。

11. 没有在声明时初始化final变量的称为空白final变量(blank final variable)，它们必须在构造器中初始化，或者调用this()初始化。不这么做的话，编译器会报错“final变量(变量名)需要进行初始化”。

12. 将类、方法、变量声明为final能够提高性能，这样JVM就有机会进行估计，然后优化。

13. 按照Java代码惯例，final变量就是常量，而且通常常量名要大写：
    private final int COUNT = 10;

14. 对于集合对象声明为final指的是引用不能被更改，但是你可以向其中增加，删除或者改变内容，譬如：

    ```java
    private final List Loans = new ArrayList();
    list.add(“home loan”);  //valid
    list.add("personal loan"); //valid
    loans = new Vector();  //not valid
    ```

### 6 接口

Java接口是一系列方法的声明，是一些方法特征的集合，**一个接口只有方法的特征没有方法的实现，因此这些方法可以在不同的地方被不同的类实现，而这些实现可以具有不同的行为（功能）**。



***我们不能直接去实例化一个接口，因为接口中的方法都是抽象的，是没有方法体的***，这样怎么可能产生具体的实例呢？但是，***我们可以使用接口类型的引用指向一个实现了该接口的对象，并且可以调用这个接口中的方法***。

- 一个类可以实现不止一个接口。

- 一个接口可以继承于另一个接口，或者另一些接口，接口也可以继承，并且可以多继承。

- 一个类如果要实现某个接口的话，那么它必须要实现这个接口中的所有方法。

- 接口中所有的方法都是抽象的和public的，所有的属性都是public,static,final的。

- 接口用来弥补类无法实现多继承的局限。




### 7 内部类

在其他类中或方法中定义的类称为`内部类`。也叫`嵌套类`

内部类分为四种：

成员内部类、本地内部类、匿名内部类、静态内部类





- 本地内部类可以访问包含它的方法中的参数，但是这些参数必须定义为 final，本地内部类中不能改变它们

  1.生命周期不同： 为什么必须局部变量加final关键字呢？因为局部变量直接存储在栈中，当方法执行结束，非final的局部变量就被销毁，而局部内部类对局部变量的引用依然存在，当局部内部类要调用局部变量时，就会出错，出现非法引用。简单来说，就是非final的局部变量的生命周期比局部内部类的生命周期短，是不是直接可以拷贝变量到局部内部类？这样内部类中就可以使用而且不担心生命周期问题呢？也是不可以的，因为直接拷贝又会出现第二个问题，就是数据不同步

  2.数据不同步：内部类并不是直接使用传递进来的参数，而是将传递进来的参数通过自己的构造器备份到自己内部，表面看是同一个变量，实际调用的是自己的属性而不是外部类方法的参数，如果在内部类中，修改了这些参数，并不会对外部变量产生影响，仅仅改变局部内部类中备份的参数。但是在外部调用时发现值并没有被修改，这种问题就会很尴尬，造成数据不同步。所以使用final避免数据不同步的问题

  那为什么添加final修饰的局部变量，就可以被局部内部类引用呢？
  若定义为final，则java编译器则会在内部类NewAge内生成一个外部变量的拷贝，而且可以既可以保证内部类可以引用外部属性，又能保证值的唯一性

  也就是拷贝了一个变量的副本，提供给局部内部类,这个副本的生命周期和局部内部类一样长，并且这个副本不可以修改，保证了数据的同步
  



## 抽象类和抽象方法

关键字：abstract

- 抽象类不能实例化。
- 抽象类中可以有抽象方法和非抽象方法，抽象方法可以用public、protected、default修饰，不能用private修饰。因为private修饰的方法不能被子类继承。
- 抽象类可以有普通类的变量和方法，可通过子类调用。
- 抽象类可以有静态方法，通过抽象类名调用。
- 抽象方法不能是静态的，因为，抽象方法是动态绑定的，而静态方法的静态绑定的。
- 拥有抽象方法的类一定是抽象类。
- 继承抽象类必须要实现抽象类中的所有抽象方法。

**父类的静态方法可以被子类重写吗？**

**不能**，**“覆盖”只有在某方法是基类的接口的一部分时才会出现。即，必须能将一个对象向上转型为它的基本类型并调用相同的方法。**

```java
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
```

结果：

```java
Son son = new Son();
son.printA();
son.printB();
son.printC();
System.out.println("-----------");
Parent parent = new Son();
parent.printA();
parent.printB();

子类静态方法A
子类普通方法B
父类静态方法C
-----------
父类静态方法A
子类普通方法B
```

说明静态方法可以被继承，printA输出“子类静态方法A",但并不是父类静态方法被重写，而是子类通过对象调用了自身的静态方法。

## final

- final 可以用来修饰类、方法和变量（包括方法参数）
- final 修饰的类不可以被继承。
- final 修饰的方法不可以被继承覆盖
- final 修饰的成员变量表示该变量是一个常量，初始化后不能被改变。
- final 修饰的静态变量，只能定义时或在静态块中进行初始化。
- final 修饰的实例变量，可以在动态块、也可以在构造函数中进行初始化。



final修饰类的使用场景：类不允许被修改或者继承重写时使用final修饰。例如，工具类。

当不允许别人创建类的实例时，可以添加一个private修饰的构造函数。

## 接口

关键字：interface

- 类实现接口使用implements。接口继承接口使用extends。
- 接口中所有变量默认为public static final, 不能用private、protected修饰
- 接口中所有方法均为public方法，但可以有抽象方法和非抽象方法，例如：静态方法，default修饰的普通方法。**如果子类实现的多个接口中有同名的default方法，必须重写。**静态方法只能通过接口名调用。

```java
interface Test05Inter1 {
    int one = 1;

    void aoo();

    default void boo() {
        System.out.println("boo()");
    }

    static void soo() {
        System.out.println("static soo()");
    }
}
```

- 类可以实现多个接口，接口也可以继承多个接口。

  

## 接口和抽象类的区别

**相同点：**

- 都不能被实例化。
- 接口的实现类或抽象类的子类都必须实现接口或抽象类的全部抽象方法。

**不同点：**

- 接口只有定义，不能有方法的实现，java 1.8中可以定义default方法体和静态方法。抽象类可以有定义与实现。
- 实现接口的关键字是implements，继承抽象类的关键字为extends。
- 一个类可以实现多个接口，但一个类只能继承一个抽象类。
- 接口没有构造方法，抽象类有构造方法。
- 接口成员变量默认为public static final，必须赋初值，不能被修改；其所有的成员方法都是public 的。抽象类中成员变量默认default，可在子类中被重新定义，也可被重新赋值；抽象方法被abstract修饰，不能被private、static等修饰。
  
  

## 内部类

内部类也叫嵌套类

分为四种：静态内部类、成员内部类、本地内部类、匿名内部类。

静态内部类可以直接访问外部类的所有静态成员，但不能访问非静态成员。

成员内部类可以直接方问外部类的所有成员，但外部类不能访问成员内部类的成员。

本地内部类不能定义静态的成员变量或方法。

本地内部类可以访问包含它的方法的参数，但这些参数必须定义为final。

匿名内部类是没有名字的内部类，因此它不能定义构造函数。

## Java Bean

定义：遵循特殊写法的类。必须有一个无参构造函数、属性必须私有，通过getter、setter方法暴露属性。

约定：

 	1. 属性不能以is开头。
 	2. 属性的第2个字母小写。
 	3. Query、VO、PO、BO属性必须使用基本类型的包装类。

**Query**：数据查询对象，接收上层的查询请求（查询数据库返回到的页面)。

**VO**：值对象，就是展示给前端的数据。

**PO**：持久对象，PO就是数据库中的记录，一个PO的数据结构对应库中表的结构，表中的一条记录就是一个PO对象。

**BO**：业务对象，BO是PO的集合。



## 注解

定义：可以声明在包、类、字段、方法、局部变量、方法参数等的前面，用于编译和运行时进行一些解析和使用，起到说明、配置的功能。

应用场景：

1、编译时检查代码。

2、动态生成代码。

3、作为额外信息的载体。

分类：

**元注解：**注解的注解，表明注解的使用范围、生命周期。

```
@Retention   表明注解的生命周期

@Target   允许自定义注解可以用在哪些元素上。

@Inherited  表示是否可以被被标注的子类继承。

@Documented   将注解的元素包含到Javadoc文档中

@Repeatable  可重复
```

**标准注解：**

```
@Override  标记一个方法是覆写父类方法。

@Deprecated  标记一个元素以过期。

@SuppressWarnings 不输出对应的编译警告。
```

**自定义注解**

```java
public @interface TestAnnotation {
}
```

**`Lombok`常用注解使用**

```
1. @Getter 和 @Setter  取代实体类中的get和set方法
2. @Data  集成以下注解
	@Getter  @Setter  @RequitedArgsConstructor  @ToString 
	@EqualsAndHashCode
3. @Builder  通过内部类和一个全参构造器来实现构造者模式
4. @AllArgsConstructor
5. @NoArgsConstructor
```



## 枚举

**作业：**静态方法的定义有什么规律，其他也说一下。

1、枚举中常量之间用逗号，分割，最后一个常量后用分号；常量必须大写，

2、枚举中定义的实例变量要用public final修饰，防止修改。

3、枚举中构造方法只能是private，不能是public，protected。

4、枚举中静态方法用public static修饰，返回值为枚举类型，方法名以类似`getByType`方式命名，两个参数，一个是获取值所依据的参数，另一个是不存在第一个参数时的返回值，通常定义为final 枚举名 `defaultIfNull`。

5、枚举中有getter方法，不能有setter方法。

**作业：** 同样是定义常量，使用枚举和类的静态变量、接口的静态变量进行对比，有哪些差异？

- 枚举常量可以附带其他属性和方法，而类的静态变量和接口的静态变量只能表示常量值。
- 枚举常量是类型安全的，因为它们属于枚举类型，而类的静态变量和接口的静态变量属于原始的数据类型。
- 枚举常量在枚举类中是唯一的，而类的静态变量和接口的静态变量可以在多个类中共享。

**定义：**`java`枚举是一种字段有一组固定常量集合组成的类型，主要目的时加强编译时类型的安全性。

**应用场景：**定义常量、强制类型、可枚举

**常用方法：**`values()`、`ordinal()`、`valueOf()`



## 泛型

**定义：**参数化类型，不必对类型进行强制化转换，提供了编译时类型安全检测机制。

**应用场景：**能够写出更加灵活通用的代码。将代码安全检查提前到编译器，能够省去类型强制转换。

**具体实现：**泛型类、泛型接口、泛型方法。

**有界类型参数：**

要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。

```java
public static <T extends Comparable<T>> T maximum(T x, T y, T z)
```

**类型通配符**

类型通配符一般是使用？代替具体的类型参数，如`List<?>`。

```java
List<? extends Number> //代表参数泛型上限为Number
List<? super Number> //代表参数泛型下限是Number
```

​                                                                                                                                                       
