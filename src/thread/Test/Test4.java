package thread.Test;

/* 两个线程轮流打印奇数和偶数 */
public class Test4 {
    //要打印的资源
    //主函数
        public static void main(String[] args) {
            Num num = new Num(); //声明一个资源
            PrintQi pQi = new PrintQi(num);
            PrintOu pOu = new PrintOu(num);
            Thread aThread = new Thread(pQi);
            Thread bThread = new Thread(pOu);
            aThread.start();
            bThread.start();
        }
}
class Num {
    int i=1;
    boolean flag = false; //两个线程，交替执行的一个标志
    int cur=0;
}
//打印奇数的线程
 class PrintQi implements Runnable{
    Num num ;
    public PrintQi(Num num)
    {
        this.num = num;
    }
    public void run()
    {
        while(num.i<= 100)
        {
            synchronized (num) {
                if(num.cur==1)
                {
                    try {
                        num.wait();
                    } catch (Exception e) {
                    }
                }
                else {
                    System.out.println("奇数"+num.i);
                    num.i++;
                    num.flag = true;
                    num.cur=1;
                    num.notify();
                }
            }
        }
    }
}

//打印偶数的线程
 class PrintOu implements Runnable{
    Num num;
    public PrintOu(Num num) {
        this.num = num;
    }
    public void run()
    {
        while(num.i<=100)
        {
            synchronized (num) {/* 必须要用一把锁对象，这个对象是num*/
                if(num.cur==0)
                {
                    try
                    {
                        num.wait();  //操作wait()函数的必须和锁是同一个
                    } catch (Exception e)
                    {}
                }
                else {
                    System.out.println("偶数-----"+num.i);
                    num.i++;
                    num.flag = false;
                    num.cur=0;
                    num.notify();
                }
            }
        }
    }
}