package thread.threadLocalTest;

public class MyTest {
    //一般将ThreadLocal的对象修饰为static对象，方便多个线程共享
    public static ThreadLocal threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask());
        Thread t2 = new Thread(new MyTask());
        Thread t3 = new Thread(new MyTask());
        //启动3个线程
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyTask implements Runnable{
    @Override
    public void run() {
        MyTest.threadLocal.set("0");
        //线程计算5次
        for(int i=1;i<5;i++){
            MyTest.threadLocal.set( MyTest.threadLocal.get().toString()+i);
        }
        System.out.println("线程"+Thread.currentThread().getName()+"的计算结果:"+MyTest.threadLocal.get());
    }

}
