class A {
    public void show() {
        System.out.println("in A show");
    }
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        A obj = new A() { // this is inner class with no name
            @Override
            public void show() {
                System.out.println("in Anonymous show");
            }
        };

        obj.show();
    }
}