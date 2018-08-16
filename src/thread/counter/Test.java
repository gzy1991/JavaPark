package thread.counter;


/* https://blog.csdn.net/wzmde007/article/details/79641084 */
/*
*
*
 *
 *  题目
给定count=0；让5个线程并发累加到1000；

思路
创建一个类MyRunnable，实现Runnable（继承Thread类也可）
定义一个公共变量count(初始值为0)，5个线程都可以访问到；
创建5个线程并发递增count到1000
*/
public class Test {

    int count =0;
    public static void main (String[] agrs){
        Test test=new Test();
        MyRunnable my1 = test.new MyRunnable();
        MyRunnable my2 = test.new MyRunnable();
        MyRunnable my3 = test.new MyRunnable();
        MyRunnable my4 = test.new MyRunnable();
        MyRunnable my5 = test.new MyRunnable();
        new Thread(my1).start();
        new Thread(my2).start();
        new Thread(my3).start();
        new Thread(my4).start();
        new Thread(my5).start();

    }

    class MyRunnable implements Runnable{
        public void run(){
            while(true){
                synchronized(MyRunnable.class){
                    if(count>=1000){
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+":count:"+(++count));
                    Thread.yield();
                }
            }
        }
    }

}
