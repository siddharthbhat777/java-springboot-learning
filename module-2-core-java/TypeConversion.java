public class TypeConversion {
    public static void main(String[] args) {
        byte b = 127;
        int a = 257;
        b = (byte) a;
        System.out.println(b);
    }   
}