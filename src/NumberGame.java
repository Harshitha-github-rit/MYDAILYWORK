import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        boolean playAgain;

        do {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            int maxAttempts = 7;  // Maximum number of attempts allowed

            System.out.println("I have generated a number between 1 and 100. Try to guess it!");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + " of " + maxAttempts + "): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1);  // More attempts left, higher score
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }
            }
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts! The number was " + targetNumber + ".");
            }

            System.out.print("Would you like to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Game Over! Your final score is: " + score);
        scanner.close();
    }
}

