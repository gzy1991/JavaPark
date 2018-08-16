package designPattern;

/**
 * Created by gzy on 2018/6/7.
 */
public class Single {
    private static Single sin=null;
    private Single(){}
    public static Single getInstance(){
        if(null==sin){
            synchronized(Single.class){
                if(null==sin){
                    sin = new Single();
                }
            }
        }
        return sin;
    }
}
