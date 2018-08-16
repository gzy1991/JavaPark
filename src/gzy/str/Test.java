package gzy.str;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by gzy on 2018/5/25.
 */
class User{
    private int score;
    private String name;
    public User(String name,int score){
        this.score=score;
        this.name=name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int age) {
        this.score = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

public class Test {
    public static int int4=70;
    public static void main(String args[])
    {
        System.out.println("*******    ***********");
        String ss1 = new StringBuilder("go").append("od").toString();
        System.out.println(ss1.intern() == ss1);
        String ss2 = new StringBuilder("ja").append("av").toString();
        System.out.println(ss2.intern() == ss2);
        String ss3 = new StringBuilder("g").append("zy").toString();
        System.out.println(ss3.intern() == ss3);
        String ss4 = new StringBuilder("gg").append("zy").toString();
        System.out.println(ss4.intern() == ss4);
        String ss5 = new StringBuilder("ja").append("vav").toString();
        System.out.println(ss5.intern() == ss5);
        System.out.println("*******    ***********");
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
        System.out.println("*******    ***********");
        List<User> list = new ArrayList<User>();
        list.add(new User("lisi", 69));
        list.add(new User("zhangsan", 90));
        list.add(new User("zhangsan", 80));
        list.add(new User("lisi", 88));

        list.add(new User("wangwu", 60));
        int int3=70;



//        Collections.sort(list,(s1,s2)-> Double.compare(s1.getScore(),s2.getScore()));
        Collections.sort(list,(s1,s2)-> Double.compare(s1.getScore(),int4));
//        Collections.sort(list, new Comparator<User>() {
//            public int compare(User user1, User user2) {
//                /**
//                 * 升序排的话就是第一个参数.compareTo(第二个参数);
//                 * 降序排的话就是第二个参数.compareTo(第一个参数);
//                 */
//                return user1.getScore()-(user2.getScore());//升序
//            }
//        });
        for (User us : list) {
            System.out.println("name:"+us.getName()+",score:"+us.getScore());
        }


        List<String> list2 = new ArrayList<String>();
        list2.add("1");
        list2.add("12");

//        System.out.println(list);

        System.out.println("*******    ***********");
        int val;
        StringBuffer sb1, sb2;

        val = 10;
        sb1 = new StringBuffer("apples");
        sb2 = new StringBuffer("pears");
        modify(val, sb1, sb2);
        System.out.println("val is " + val);
        System.out.println("sb1 is " + sb1);
        System.out.println("sb2 is " + sb2);


        System.out.println("*******    ***********");
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
//        List m =new ArrayList();
//        m.add(5);
//        m.add("1");
//        m.add(5);
//
//
//        for (int i = 0; i < m.size(); i++) {
//            String name = (String) m.get(i); // 1
//            System.out.println("name:" + name);
//        }
    }

    public static void modify(int a, StringBuffer r1, StringBuffer r2)
    {
        a = 0;
        r1 = null;


        r2.append(" taste good");
    }

    public <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }

    public class Generic<T>{
        //key这个成员变量的类型为T,T的类型由外部指定
        private T key;

        public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
            this.key = key;
        }

        public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
            return key;
        }
    }
//泛型的类型参数只能是类类型（包括自定义类），不能是简单类型

}
