package gzy.str;

/**
 * Created by gzy on 2018/5/22.
 */
public class stringTest {
    String str = new String("good");
    char[] ch = { 'a', 'b', 'c' };

    public static void main(String[] args){
        String s1="a"+"b"+"c";
        String s2="abc";
        String s3="abc";
        String s4=s1+s2+s3;  //StringBuffer 拼接之后 toString，
        String s5="abcabcabc";
        String s6=new String("abc");
        String s7=new String("abc");
        System.out.println(s1==s2);         //  true
        System.out.println(s4==s5);         //  false
        System.out.println(s4.equals(s5));  //  true
        System.out.println(s6==s7);         // false
        System.out.println(s6.equals(s7));  //  true

        final String s8="a";
        String s9=s8+"b"; //String s9 = "a"+"b" 对于final修饰的变量，它在编译时被解析为常量值的一个本地拷贝存储到自己的常量 池中或嵌入到它的字节码流中

        String s10="a";
        String s11=s10+"b";

        System.out.println("ab"==s9);       //true
        System.out.println("ab"==s11);      //false


        System.out.println("********* Integer 包装类 *********");
        int i = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);
        System.out.println(i == i2); //Integer会自动拆箱为int，
        System.out.println(i == i3); //
        Integer i4 = 127;//编译时被翻译成：Integer i4 = Integer.valueOf(127);
        Integer i5 = 127;
        System.out.println(i4 == i5);//
        Integer i6 = 128;
        Integer i7 = 128;
        System.out.println(i6 == i7);//
        Integer i8 = new Integer(127);
        System.out.println(i5 == i8); //
        Integer i9 = new Integer(128);
        Integer i10 = new Integer(123);
        System.out.println(i9 == i10);  //


        System.out.println("*******  值传递  ***********");
        int a = 3;
        int b = 4;
        change(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        int[] count = { 1, 2, 3, 4, 5 };
        change2(count);
        System.out.println("count[0]:"+count[0]);

        A aa = new A();
        add(aa);
        System.out.println("aa.i:"+aa.i);

        stringTest ex=new stringTest();
        ex.change3(ex.str,ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);



    }
    public static void change(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }
    public static void change2(int[] counts) {
        counts[0] = 6;
        System.out.println("counts[0]:"+counts[0]);

    }
    public static void add(A a) {
        a = new A();
        a.i++;
    }
    public void change3(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }
}
class A {
    int i = 0;
}
