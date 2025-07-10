@FunctionalInterface
interface A {
    void show();
}

@FunctionalInterface
interface ParameterisedA {
    void showPA(int i);
}

@FunctionalInterface
interface ReturnValueA {
    int add(int a, int b);
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        A obj = new A() {
            @Override
            public void show() {
                System.out.println("in show");
            }
        };
        A obj1 = () -> { // can be done only for functional interface
            System.out.println("in lambda show");
        };
        // OR
        A obj2 = () -> System.out.println("in lambda one line show");

        // Parameterised lambda
        ParameterisedA obj3 = (int i) -> System.out.println("in show PA = " + i);

        // Don't even need to specify type of variable and noo need for () if there is single variable
        ParameterisedA obj4 = i -> System.out.println("in show PA no type = " + i);

        // lambda with return value
        ReturnValueA obj5 = (a, b) -> a + b;
        
        obj.show();
        obj1.show();
        obj2.show();
        obj3.showPA(5);
        obj4.showPA(8);
        int result = obj5.add(3, 7);
        System.out.println("Sum = " + result);
    }
}