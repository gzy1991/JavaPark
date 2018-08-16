package duotai;

/**
 * Created by gzy on 2018/5/16.
 */
/*
 *
 *     多态的优缺点
 *         优点：可以提高可维护性（多态前提所保证的），提高代码的可扩展性
        缺点：无法直接访问子类特有的成员
 */
public class PoymorphicDemo4 {
    public static void main(String[] args) {
        MiFactory factory = new MiFactory();
        factory.createPhone(new MiNote());

        factory.createPhone(new RedMi());
    }


}

class MiFactory {
    /*public void createPhone(MiNote mi) {
        mi.call();
    }

    public void createPhone(RedMi mi) {
        mi.call();
    }*/

    public void createPhone(Phone p) {
        p.call();
    }

}

interface Phone {
    public void call();
}

//小米Note
class MiNote implements Phone{
    public void call() {
        System.out.println("小米Note打电话");
    }
}

//红米
class RedMi implements Phone {
    public void call() {
        System.out.println("红米打电话");
    }
}
