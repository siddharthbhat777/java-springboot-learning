abstract class A {
    public static int var = 1;
    int var2 = 2; // pointless, can never be called
    public abstract void show();
    public void config() {
        System.out.println("in config");
    }
}

class B extends A {
    @Override
    public void show() {
        System.out.println("in show");
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(B.var);
        obj.show();
        obj.config();
    }
}