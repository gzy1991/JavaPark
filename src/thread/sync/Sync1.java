package thread.sync;

/*http://www.cnblogs.com/QQParadise/articles/5059824.html
* synchronized锁住的是代码还是对象
*
* 这个例子中synchronized没起作用，
* */

class Sync {
    public synchronized void test() {
        System.out.println("test开始..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test结束..");
    }
}

class MyThread extends Thread {
    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}

public class Sync1 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread();
            thread.start();
        }
    }

}
