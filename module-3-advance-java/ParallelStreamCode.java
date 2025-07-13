
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStreamCode {
    public static void main(String[] args) {
        int size = 10_000; // Define the size of the list
        List<Integer> nums = new ArrayList<>();
        Random ran = new Random();
// Populate the list with random integers between 0 and 99 
        for (int i = 1; i <= size; i++) {
            nums.add(ran.nextInt(100));
        }
// Measure execution time for sequential stream processing 
        long startSeq = System.currentTimeMillis();
        int sumSeq = nums.stream()
                .map(i -> {
                    try {
                        Thread.sleep(1); // Simulate processing delay
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return i * 2;
                })
                .mapToInt(i -> i) // Convert Stream<Integer> to IntStream 
                .sum();
        long endSeq = System.currentTimeMillis();
// Measure execution time for parallel stream processing 
        long startPara = System.currentTimeMillis();
        int sumPara = nums.parallelStream()
                .map(i -> {
                    try {
                        Thread.sleep(1); // Simulate processing delay 
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return i * 2;
                })
                .mapToInt(i -> i) // Convert Stream<Integer> to IntStream
                .sum();
        Long endPara = System.currentTimeMillis();
// Print results
        System.out.println("Sequential Sum: " + sumSeq + " | Parallel Sum: " + sumPara);
        System.out.println("Sequential Time: " + (endSeq - startSeq) + "ms");
        System.out.println("Parallel Time: " + (endPara - startPara) + "ms");
    }
}
