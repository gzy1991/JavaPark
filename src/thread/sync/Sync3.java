package thread.sync;
/*
synchronized起作用了
synchronized锁住的是括号里的对象，而不是代码。
对于非static的synchronized方法，锁的就是对象本身也就是this。
*/
class Sync33{
    public void test(){
        synchronized (this){
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
class Mythread3 extends Thread{
    private Sync33 sync;
    public Mythread3(Sync33 sync) {
        this.sync = sync;
    }
    public void run(){
        sync.test();
    }
}
public class Sync3 {
    public static void main(String[] args){
        Sync33 sync = new Sync33();
        for(int i=0;i<3;i++){
            Thread th= new Mythread3(sync);
            th.start();
        }
    }
}
