
import java.util.Arrays;
import java.util.Scanner;

public class QuestionService {

    Question[] questions = new Question[5];
    String[] selection = new String[5];

    public QuestionService() {
        questions[0] = new Question(1, "size of int", new String[] {"2", "6", "4", "8"}, "4");
        questions[1] = new Question(2, "size of double", new String[] {"2", "6", "4", "8"}, "8");
        questions[2] = new Question(3, "size of char", new String[] {"2", "6", "4", "8"}, "2");
        questions[3] = new Question(4, "size of long", new String[] {"2", "6", "4", "8"}, "8");
        questions[4] = new Question(5, "size of boolean", new String[] {"1", "2", "4", "8"}, "1");
    }

    public void playQuiz() {
        int i = 0;
        for (Question question : questions) {
            System.out.println("Question number: " + question.getId());
            System.out.println(question.getQuestion());
            System.out.println(Arrays.toString(question.getOptions()));
            Scanner scanner = new Scanner(System.in);
            selection[i] = scanner.nextLine();
            i++;
        }
        System.out.println("Your selections:");
        for (String s : selection) {
            System.out.println(s);
        }
        System.out.println("Answers:");
        for (Question q : questions) {
            System.out.println(q.getAnswer());
        }
    }

    public void printScore() {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            Question que = questions[i];
            String answer = que.getAnswer();
            String userAnswer = selection[i];
            if (answer.equals(userAnswer)) {
                score++;
            }
        }
        System.out.println("Your score is : " + score);
    }
}