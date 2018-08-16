package test;

/*单例模式*/
/**
 * Created by gzy on 2018/5/16.
 */

public class Project {
    private static Project pro=null;
    public  String name="1";
    private  Project(){
        System.out.println( "new a Project");

    }
    public static Project getInstance(){
        if(null==pro){
            synchronized (Project.class){
                if(null==pro){
                    pro=new Project();
                }
            }
        }
        return pro;
    }
}

