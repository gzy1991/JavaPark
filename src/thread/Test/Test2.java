package thread.Test;

/*启动3个线程打印递增的数字，线程1打印1、2、3，线程2打印4、5、6，线程打印7、8、9，。。。一次类推，直到75*/

/*线程间通信-基于Object的wait/notify*/

public class Test2 {
    public static void main(String[] args)throws InterruptedException{
        Num2 num= new Num2();
        Test2 t = new Test2();
        Thread t1=new Thread(new myThread0(num,0));
        Thread t2=new Thread(new myThread1(num,1));
        Thread t3=new Thread(new myThread2(num,2));
        t1.start();
        t2.start();
        t3.start();
    }
}
class Num2{
    int i=0;
    int cur = 0; //3个线程，交替执行的一个标志 cur=0、1、2
}
class myThread0 implements Runnable{
    Num2 num;
    private int n=0;
    public myThread0(Num2 n ,int i){
        num =n;
        this.n=i;
    }
    public void run(){
        try{
            System.out.println(Thread.currentThread().getName()+":start()");
            while(num.i<75){
                synchronized (num){
                    if(num.cur != 0){
                        System.out.println(Thread.currentThread().getName()+":wait()");
                        num.wait();
                        System.out.println(Thread.currentThread().getName()+":notify()");
                    }else{
                        System.out.println(Thread.currentThread().getName()+":"+(++num.i));
                        System.out.println(Thread.currentThread().getName()+":"+(++num.i));
                        System.out.println(Thread.currentThread().getName()+":"+(++num.i));
                        num.cur = 1;
                        num.notifyAll();
                        System.out.println(Thread.currentThread().getName()+":notifyAll()");
                    }
                }
            }
            System.out.println(Thread.currentThread().getName()+":end()");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class myThread1 implements Runnable{
    Num2 num;
    private int n=0;
    public myThread1(Num2 obj ,int i){
        this.n=i;
        this.num=obj;
    }
    public void run(){
        try{
            System.out.println(Thread.currentThread().getName()+":start()");
            while(num.i<75){
                synchronized (num){

                    if(num.cur != 1){
                        System.out.println(Thread.currentThread().getName()+":wait()");
                        num.wait();
                        System.out.println(Thread.currentThread().getName()+":notify()");
                    }else{
                        System.out.println(Thread.currentThread().getName()+":"+(++num.i));
                        System.out.println(Thread.currentThread().getName()+":"+(++num.i));
                        System.out.println(Thread.currentThread().getName()+":"+(++num.i));
                        num.cur = 2;
                        num.notifyAll();
                        System.out.println(Thread.currentThread().getName()+":notifyAll()");
                    }
                }
            }
            System.out.println(Thread.currentThread().getName()+":end()");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class myThread2 implements Runnable{
    Num2 num;
    private int n=0;
    public myThread2(Num2 obj ,int i){
        this.n=i;
        this.num=obj;
    }
    public void run(){
        try{
            System.out.println(Thread.currentThread().getName()+":start()");
            while(num.i<75){
                synchronized (num){
                    if(num.cur != 2){
                        System.out.println(Thread.currentThread().getName()+":wait()");
                        num.wait();
                        System.out.println(Thread.currentThread().getName()+":notify()");
                    }else{
                        System.out.println(Thread.currentThread().getName()+":"+(++num.i));
                        System.out.println(Thread.currentThread().getName()+":"+(++num.i));
                        System.out.println(Thread.currentThread().getName()+":"+(++num.i));
                        num.cur = 0;
                        num.notifyAll();
                        System.out.println(Thread.currentThread().getName()+":notifyAll()");
                    }
                }
            }
            System.out.println(Thread.currentThread().getName()+":end()");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


