package duotai;

/**
 * Created by gzy on 2018/5/16.
 */
/*
 *
 *     多态中的向上转型和向下转型:
 *
 *  引用类型之间的转换
 *      向上转型
 *          由小到大(子类型转换成父类型)
 *      向下转型
 *          由大到小
 *  基本数据类型的转换
 *      自动类型转换
 *          由小到大
 *          byte short char --- int --- long --- float --- double
 *      强制类型转换
 *          由大到小
 *
 *
 *
 */
public class PoymorphicDemo3 {
    public static void main(String[] args) {
        Animal2 a = new Dog();//向上转型
        a.eat();

        Dog d = (Dog)a;//向下转型
        d.swim();

    }
}

class Animal2 {
    public void eat() {
        System.out.println("吃东西");
    }
}


class Dog extends Animal2 {
    public void eat() {
        System.out.println("啃骨头");
    }

    public void swim() {
        System.out.println("狗刨");
    }
}
