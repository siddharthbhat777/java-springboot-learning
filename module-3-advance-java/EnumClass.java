
enum Laptop {
//	Mackbook(2000), XPS(2200), Surface(1500), ThinkPad(1800);
    Mackbook(2000), XPS(2200), Surface, ThinkPad(1800); // if you hover you will see these are constructors

    private int price;

    private Laptop() {
        price = 500;
    }

    /* 
    Why private constructors?
    
    Constructors in Java can have access modifiers such as public, protected, and private. The constructors' accessibility and visibility are managed by these access modifiers.
    In Java, an enum is a special type of class that represents a group of constants. When you define an enum, you are defining a new type that has a fixed set of constant values.
    Allowing public or protected constructors in enums would permit the creation of enum instances outside the predefined set, which goes against the fundamental concept of an enum.
    Making the constructor private ensures this, it has a fixed, unchangeable set of instances.
     */
    private Laptop(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        System.out.println("in Laptop" + this.name());
    }
}

public class EnumClass {

    public static void main(String[] args) {

//    	Laptop lap=Laptop.Mackbook;
//    	System.out.println(lap+ " : "+lap.getPrice());
        for (Laptop lap : Laptop.values()) {
            System.out.println(lap + " : " + lap.getPrice());
        }
    }
}
