class A {
    public void show() {
        System.out.println("in A Show");
    }
    public void show1() {
        System.out.println("in A Show 1");
    }
}

class B extends A {
    // Overriding show()
    public void show() {
        System.out.println("in B Show");
    }
    
    public void show2() {
        System.out.println("in B Show 2");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {
        A obj = new A();
        obj.show(); // will call method of A
        
        obj = new B(); // Similar to B obj = new B(), but with this obj you can access parent A() as well as shown above
        obj.show(); // will call method of B
        // B obj1 = new A(); // won't work
        // obj1.show(); // will give runtime error
    }
}