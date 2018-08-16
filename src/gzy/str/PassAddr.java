package gzy.str;

/**
 * Created by gzy on 2018/5/25.
 */
class Book{
    String name;
    private float price;
    Book(String n,    float p){                //构造方法
        name= n;
        price= p;
    }
    static  void change(Book a_book,    String n,    float p){    //静态方法，对象作为参数
        a_book.name= n;
        a_book.price= p;
    }
    public void output(){        //实例方法，输出对象信息
        System.out.println("name:" + name + "/t" + "price: " + price);
    }
}
public class PassAddr{
    public static void main(String [] args){
        Book b = new Book("java2",    32.5f);
        System.out.print("beforecall:/t");        //调用前
        b.output();
        b.change(b,    "c++",    45.5f);            //引用传递，传递对象b的引用，修改对象b的值
        System.out.print("aftercall:/t");            //调用后
        b.output();
    }
}
