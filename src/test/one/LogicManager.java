package test.one;

/**
 * Created by gzy on 2018/5/16.
 */
public class LogicManager implements IManager{
    private static IManager instance=null;
    private LogicManager(){}

    public static IManager getInstance (){
        if(null==instance){
            synchronized (LogicManager.class){
                if(null==instance){
                    instance=new LogicManager();
                }
            }
        }
        return instance;
    }
}
