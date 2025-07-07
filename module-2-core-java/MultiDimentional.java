public class MultiDimentional {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            if (i < 4) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = i; j < 7; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
