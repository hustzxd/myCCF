package Wanluo;

/**
 * Created by buxia on 2015/9/8.
 */
public class Test {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.getA());
        B b = new B();
        System.out.println(b.getB());
        B[] bs  = new B[2];
    }
}

class A {
    private int a;

    public int getA() {
        return a;
    }
}

class B implements IB {

    private int b;

    @Override
    public int getB() {
        return b;
    }
}

interface IB {
    int getB();
}