
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TakingInput {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a number:");

        // Old way
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in); // can read any type of input, even image upload
        
        int num = Integer.parseInt(br.readLine());
        System.out.println(num);

        // br.close(); // if you do this before any other scanner, you will face error

        // New way
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(number);
    }
}