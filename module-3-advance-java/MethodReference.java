
import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sid", "Ruchika", "Madhusudan", "Priyanka");

        // Normal way
        List<String> uNames = names.stream().map(name -> name.toUpperCase()).toList();
        uNames.forEach(uName -> System.out.println(uName));

        // Method Reference way
        List<String> refNames = names.stream().map(String::toUpperCase).toList();
        refNames.forEach(System.out::println); 
        /* 
        Left side => Which class the method belongs 
        Right side => method you want to use
        */
    }
}