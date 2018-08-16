package gzy.str;

/**
 * Created by gzy on 2018/5/25.
 */
public class PassValue{
     static void exchange(int a, int b){//静态方法，交换a,b的值
         int temp;
         temp= a;
         a= b;
         b= temp;
     }
    public static void main(String[] args){
        int i = 10;
        int j = 100;
        System.out.println("beforecall: " + "i=" + i + "/t" + "j = " + j);//调用前
        exchange(i,j);//值传递，main方法只能调用静态方法
        System.out.println("aftercall: " + "i=" + i + "/t" + "j = " + j);//调用后
    }
}
