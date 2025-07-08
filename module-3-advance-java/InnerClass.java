class A {
    public void show() {
        System.out.println("in show");
    }

    class B {
        public void configOfB() {
            System.out.println("in B config");
        }
    }
    
    static class C {
        public void configOfC() {
            System.out.println("in C config");
        }
    }
}

public class InnerClass {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();
        A.B obj1 = obj.new B(); // need to use object of class A to access class B
        obj1.configOfB();
        A.C obj2 = new A.C(); // if inner class is static you can directly use it
        obj2.configOfC();
    }
}