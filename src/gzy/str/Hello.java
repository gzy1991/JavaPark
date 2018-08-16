package gzy.str;

/**
 * Created by gzy on 2018/5/29.
 */
public class Hello {
    public static void main(String[] args) {
        C ab = new B();
        ab = new B();
        D d=new Hello().new D();
    }
    class D{

    }
    class E{    }
}
class C {

    static {
        System.out.print("1");
    }

    public C() {
        System.out.print("2");
    }
}

class B extends C{

    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
    }
}
