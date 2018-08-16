package thread.threadCreate;

public class ThreadDemo02 {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new Thread(new MyThread());
        System.out.println(Thread.currentThread().getName());
        t1.start();
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(Thread.currentThread().getName()+"-->我是通过实现接口的线程实现方式！");
    }
}
