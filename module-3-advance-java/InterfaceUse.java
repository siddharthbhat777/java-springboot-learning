interface Computer {
    void code();
}

class Laptop implements Computer {
    @Override
    public void code() {
        System.out.println("code, compile, run");
    }
}

class Desktop implements Computer {
    @Override
    public void code() {
        System.out.println("code, compile, run : Faster");
    }
}

class Developer {
    public void devApp(Computer computer) {
        computer.code();
    }
}

public class InterfaceUse {
    public static void main(String[] args) {
        Computer laptop = new Laptop();
        Computer desktop = new Desktop();

        Developer sid = new Developer();
        sid.devApp(desktop);
    }
}