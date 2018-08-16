package thread.sync;


/*没有看到synchronized起到作用*/

class Sync22 {
    public  void test() {
        synchronized(this){
            System.out.println("test开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }
    }
}

class MyThread2 extends Thread {
    public void run() {
        Sync22 sync = new Sync22();
        sync.test();
    }
}

public class Sync2 {

    public static void main(String[] args) {
        Sync2 sync = new Sync2();
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread2();
            thread.start();
        }
    }
}