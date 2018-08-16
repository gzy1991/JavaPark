package thread.Test;

import thread.counter.Test;
import thread.sync.Sync3;

/*用java多线程模拟一个死锁程序*/
public class Test1 {
    public  static String res1="res1";
    public  static String res2="res2";
    public  static boolean res3=true;
    public static void main(String[] args){
        Test1 test = new Test1();
        Thread a= new Thread(test.new MythreadA());
        Thread b= new Thread(test.new MythreadB());
        a.start();
        b.start();
    }
    class MythreadA implements Runnable{
        public void run(){
            try{
                System.out.println("MythreadA:"+Thread.currentThread().getName()+" start");
                while(true){
                    synchronized (Test1.res1){
                        System.out.println("MythreadA:"+Thread.currentThread().getName()+" 拿到了res1");
                        Thread.sleep(1000);
                        System.out.println("MythreadA:"+Thread.currentThread().getName()+" 想拿res2");
                        synchronized (Test1.res2){
                            System.out.println("MythreadA:"+Thread.currentThread().getName()+" 拿到了res2");
                            Thread.sleep(1000);
                        }
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    class MythreadB implements Runnable{
        public void run(){
            try{
                System.out.println("MythreadB:"+Thread.currentThread().getName()+" start");
                while(true){
                    synchronized (Test1.res2){
                        System.out.println("MythreadB:"+Thread.currentThread().getName()+" 拿到了res2");
                        Thread.sleep(1000);
                        System.out.println("MythreadB:"+Thread.currentThread().getName()+" 想拿res1");
                        synchronized (Test1.res1){
                            System.out.println("MythreadB:"+Thread.currentThread().getName()+" 拿到了res1");
                            Thread.sleep(1000);
                        }
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

