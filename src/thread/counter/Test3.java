package thread.counter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/*
*
* 使用AtomicInteger类，来实现多线程累加，AtomicInteger类是线程安全的，
* 使用它的优点就是我们不需要在代码里写Synchronized关键字了，这些事都交给它去做了。


 */
public class Test3 {
    static CountDownLatch cdl= new CountDownLatch(1000);
    static AtomicInteger ai =new AtomicInteger(0);

    public static void main(String [] args)throws InterruptedException{
        ExecutorService exec= Executors.newFixedThreadPool(100);
        for(int i=0;i<1000;i++){
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+":"+ai.getAndIncrement());
                    cdl.countDown();
                }
            });
        }
        cdl.await();
        System.out.println(ai.get());
        exec.shutdown();


    }

}
