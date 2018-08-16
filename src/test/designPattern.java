package test;
import test.Project;
import java.io.IOException;

/**
 * Created by gzy on 2018/5/16.
 */
public class designPattern {
    public static void main(String[] args) {
        System.out.println("获取数组args[]的数据");
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
        System.out.println(Project.getInstance().name);
        Project p1=Project.getInstance();
        Project p2=Project.getInstance();
        System.out.println( p1.name);
        p1.name="p2";
        System.out.println( p2.name);


//        String s1="gzy";
//        String s2="gzy";
//        System.out.println( s2==s1);
//        System.out.println( s2.equals(s1));

    }
}
