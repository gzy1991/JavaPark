package thread.threadCreate;

public class ThreadDemo01 extends Thread{
    public ThreadDemo01(){
        //编写子类的构造方法，可缺省
    }
    public void run(){
        //编写自己的线程代码
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args){
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        threadDemo01.setName("我是自定义的线程1");
        threadDemo01.start();
        System.out.println(Thread.currentThread().toString());

        MyThre threadDemo02 = new MyThre();
        threadDemo02.setName("我是自定义的线程2");
        threadDemo02.start();
        System.out.println(Thread.currentThread().toString());
    }
}

class MyThre extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}