package test;

/**
 * Created by gzy on 2018/7/3.
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println(XYZ.name);
        System.out.println(XYZ.name);
        XYZ.pro();
    }
}

class XYZ {
    public static String name = "luoxn28";

    static {
        System.out.println("xyz静态块");
    }

    public XYZ() {
        System.out.println("xyz构造了");
    }

    protected static void pro(){
        System.out.println("pro");
    }
    private static void pri(){
        System.out.println("pri");
    }
}
