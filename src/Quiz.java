import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {

    private static int score = 0;
    private static boolean timeOut = false;
    private static final int TIME_LIMIT = 10;  // Time limit per question (in seconds)
    private static Timer timer = new Timer();


    static class Question {
        String question;
        String[] options;
        char correctAnswer;

        public Question(String question, String[] options, char correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
        public void displayQuestion() {
            System.out.println(question);
            for (int i = 0; i < options.length; i++) {
                System.out.println((char) ('A' + i) + ": " + options[i]);
            }
        }
    }

    static Question[] questions = {
            new Question("What is the capital of France?", new String[]{"Berlin", "Paris", "Madrid", "Rome"}, 'B'),
            new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Venus", "Mars", "Jupiter"}, 'C'),
            new Question("Who wrote 'Hamlet'?", new String[]{"Charles Dickens", "J.K. Rowling", "William Shakespeare", "Mark Twain"}, 'C')
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            timeOut = false;

            // Display the current question
            System.out.println("\nQuestion " + (i + 1) + ":");
            questions[i].displayQuestion();

            startTimer();

            char userAnswer = getUserAnswer(scanner);
            timer.cancel();
            if (timeOut) {
                System.out.println("Time's up! No answer submitted.");
            } else {
                if (userAnswer == questions[i].correctAnswer) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer was " + questions[i].correctAnswer + ".");
                }
            }
            timer = new Timer();
        }

        System.out.println("\nQuiz Over! Your final score is: " + score + " out of " + questions.length);
        scanner.close();
    }

    private static void startTimer() {
        timer.schedule(new TimerTask() {
            public void run() {
                timeOut = true;
            }
        }, TIME_LIMIT * 1000);
    }
    private static char getUserAnswer(Scanner scanner) {
        char answer = ' ';
        try {
            answer = scanner.next().toUpperCase().charAt(0);
        } catch (Exception e) {
        }
        return answer;
    }
}
