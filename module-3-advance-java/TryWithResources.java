
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryWithResources {
    public static void main(String[] args) throws IOException {
        int num = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            num = Integer.parseInt(br.readLine());
            System.out.println(num);
        } finally {
            // br.close();
        }

        // This is try-with-resources where you don't need to use finally
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            num = Integer.parseInt(bf.readLine());
            System.out.println(num);
        }
    }
}