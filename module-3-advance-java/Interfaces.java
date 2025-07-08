interface A {
    // variables by default static and final
    int var = 2;
    
    // methods by default public abstract
    void show();
    void config();
}

class B implements A {
    @Override
    public void show() {
        System.out.println("in show");
    }

    @Override
    public void config() {
        System.out.println("in config");
    }
}

public class Interfaces {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(B.var);
        obj.show();
        obj.config();
    }
}