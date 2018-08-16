package accessModifier;
/*Java访问控制符*/
public class test {
    public static void main(String[] args){
        MyClass1 myclaa1 = new MyClass1();
        myclaa1.run();
        MyClass1 myClass2[]=new MyClass1[3];
        int len =myClass2.length;


    }
    void run7(){}
    protected  void run8(){}
    private void run10(){}
}

class MyClass1{
    void run(){  }
    private void run2(){    }
    public void run3(){  }
    protected void run4(){    }
}

class son extends MyClass1{
    public void run5(){
        run();
        run3();
        run4();
    }
}