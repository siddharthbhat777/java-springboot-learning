
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{");
        sb.append("name=").append(name);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
} 

public class ConstructorReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sid", "Ruchika", "Madhusudan", "Priyanka");

        List<Student> students = new ArrayList<>();

        // Normal way too add object array data
        /* for (String name : names) {
            students.add(new Student(name));
        } */

        // Using stream
        // Normal way
        // students = names.stream().map(name -> new Student(name)).toList();
        // with constructor reference
        students = names.stream().map(Student::new).toList();

        System.out.println(students);
    }
}