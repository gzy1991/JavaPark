package thread.sync;

class Sync55 {
    public synchronized static void test() {
         {
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
class MyThread5 extends Thread {
    public void run() {
//        Sync55 sync = new Sync55();
//        sync.test();
        Sync55.test();
    }
}
public class Sync5 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread5();
            thread.start();
        }
    }

}
