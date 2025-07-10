
class A extends Thread {

    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Hi");
        }
    }
}

class B extends Thread {

    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Hello");
        }
    }
}

public class ThreadsConcept {
    public static void main(String[] args) throws NumberFormatException {
        A obj1 = new A();
        B obj2 = new B();
        System.out.println(obj1.getPriority());

        // obj1.show();
        // obj2.show();
        obj1.start(); // start invokes run() method on class extending Thread
        obj2.start();
    }

}
