import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the maximum number of attempts
        System.out.print("Enter the maximum number of guesses: ");
        int maxAttempts = scanner.nextInt();

        // Ask the user for the maximum number for the random number
        System.out.print("Enter the maximum value for the random number: ");
        int maxNumber = scanner.nextInt();

        // Create a GuessTheNumberGame object and play the game
        NumberGame game = new NumberGame(maxAttempts, maxNumber);
        game.play();
        game.close(); // Close the scanner after the game is over

        // Close the main scanner to avoid resource leak
        scanner.close();
    }
}
