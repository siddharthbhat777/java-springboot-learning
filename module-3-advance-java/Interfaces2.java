interface A {
    void show();
}

interface B extends A { // use "extend" keyword for INTERFACE -> INTERFACE
    void config();
}

class X implements B {
    @Override
    public void config() {
        System.out.println("in config");
    }

    @Override
    public void show() {
        System.out.println("in show");
    }
}

public class Interfaces2 {
    public static void main(String[] args) {
        X obj = new X();
        obj.show();
        obj.config();
    }
}