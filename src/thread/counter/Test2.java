package thread.counter;

/*
*
* 方法二
以上代码没有问题，成功实现5个线程累加count到1000，接下来我们将上边代码稍作修改。

将5个线程执行5个任务，修改为5个线程执行同一任务。
将synchronized(MyRunnable.class)修改为synchronized(this)

*/

/*
*
*
*
虽然结果是一样的，但是代码实现是不一样的，代码一是创建了5个MyRunnable对象，代码二只创建了1个MyRunnable对象。
考虑并发时用到的锁就是不一样的，代码一我们需要锁住整个类，因为对象是不同的，而针对代码二我们只需要锁住一个对象即可。

synchronized(this)代表锁住同一对象。
synchronized(MyRunnable.class)代表锁住整个MyRunnable类的对象。*/
public class Test2 {


    private int count = 0;
    public static void main(String[] args){
        Test2 test = new Test2();
        MyRunable my1 = test.new MyRunable();
        for(int i =0;i<4;i++){
            new Thread(my1).start();
        }
    }

    //创建一个实现Runnable的类
    class MyRunable implements Runnable{

        public void run(){
            while (true){
                synchronized (this){
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
