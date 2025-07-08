abstract class A {
    public abstract void show();
}

// normal solution
/* class B extends A {
    @Override
    public void show() {
        System.out.println("declared abstract method");
    }
} */

public class AnonymousInnerClassUse {
    public static void main(String[] args) {
        // problem
        // A obj = new A(); // cannot instantiate abstract class

        // normal solution
        /* A obj = new B();
        obj.show(); */

        // Anonymous innner class short solution
        A obj = new A() {
            @Override
            public void show() {
                System.out.println("declared abstract method");
            };
        };
        obj.show();
    }
}