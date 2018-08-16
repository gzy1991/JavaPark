package thread;

public class ThreadTest implements  Runnable {
    public static void main (String [] agrs) throws InterruptedException{

        Thread a= new Thread(new ThreadTest());
        Thread b= new Thread(new ThreadTest());
        Thread c= new Thread(new ThreadTest());
        a.start();
        b.start();
        c.start();

    }

    public void run() {
        try{
            for(int i=0;i<5;i++){
                System.out.println( Thread.currentThread().getName()+":"+i);
                Thread.sleep(1000);
            }
        }catch (Exception InterruptedException){

        }
    }


}
