package duotai;

/**
 * Created by gzy on 2018/5/16.
 */
/*
 * 多态的前提：
 *     子父类的继承关系
 *     方法的重写
 *     父类引用指向子类对象
 *
 * 动态绑定：运行期间调用的方法，是根据其具体的类型
 *
 *
 *
 *
 */
public class PoymorphicDemo {
    public static void main(String[] args) {
        /*Cat c = new Cat();
        c.eat();*/

        //父类引用 Animal a
        //指向     =
        //子类对象 new Cat()

        Animal a = new Cat();
        a.eat();

    }
}

class Animal {
    public void eat() {
        System.out.println("吃东西");
    }
}


class Cat extends Animal {
    public void eat() {
        System.out.println("猫吃鱼");
    }
}