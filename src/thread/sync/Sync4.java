package thread.sync;
/*代码用synchronized(Sync44.class)实现了全局锁的效果。*/
/*static synchronized方法，
static方法可以直接类名加方法名调用，方法中无法使用this，
所以它锁的不是this，而是类的Class对象，
所以，static synchronized方法也相当于全局锁，相当于锁住了代码段。
 */
class Sync44 {
    public void test() {
        synchronized (Sync44.class) {
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
class MyThread4 extends Thread {
    public void run() {
        Sync44 sync = new Sync44();
        sync.test();
    }
}
public class Sync4 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread4();
            thread.start();
        }
    }

}
