
class SiddharthException extends Exception {
    public SiddharthException(String string) {
        super(string); // passing value to constructor of Exception class
    }
}

public class CustomException {

    public static void main(String[] args) {

        // int i = 2;
        // int i = 0;
        int i = 20;
        int j = 0;

        try {
            j = 18 / i;
            if (j == 0) // throw new Exception("I don't want to do print zero");
            {
                throw new SiddharthException("I don't want to do print zero");
            }
        } catch (ArithmeticException e) {
            j = 18 / i;
            System.out.println("that is default output" + e);

        // System.out.println("Cannot divide by zero");
        } catch (Exception e) {

            System.out.println("Something went wrong." + e);
        }
        System.out.println(j);
        System.out.println("Bye");
    }
}
