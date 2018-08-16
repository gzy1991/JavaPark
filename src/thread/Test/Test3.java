package thread.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*启动3个线程打印递增的数字，线程1打印1、2、3，线程2打印4、5、6，线程打印7、8、9，。。。一次类推，直到75*/
public class Test3 {

    public static void main(String[] args){
        final Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 1");
            }
        }, "T1");
        final Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 2");
                try {
                    t1.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T2");
        final Thread t3 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 3");
                try {
                    t2.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T3");
        // method1
        //t1.start();
        //t2.start();
        //t3.start();

//        method 2 使用 单个任务的线程池来实现。保证线程的依次执行
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(t1);
        executor.shutdown();
        executor.submit(t2);
        executor.shutdown();
        executor.submit(t3);
        executor.shutdown();
//        for(int i=0;i<25;i++){
//            executor.submit(t1);
//            executor.submit(t2);
//            executor.submit(t3);
//        }


    }



}
