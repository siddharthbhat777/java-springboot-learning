
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sid", "Ruchika", "Madhusudan", "Priyanka");

        // Use optional to avoid NullPointerException
        Optional<String> name = names.stream().filter(str -> str.contains("z")).findFirst();

        System.out.println(name.orElse("Name not found"));
    }
}