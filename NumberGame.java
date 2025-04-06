import java.util.Random;
import java.util.Scanner;

public class NumberGame implements Game {

    private int randomNumber;
    private int maxAttempts;
    private int maxNumber;
    private int attempts;
    private boolean guessedCorrectly;
    private Scanner scanner;

    // Constructor
    public NumberGame(int maxAttempts, int maxNumber) {
        this.maxAttempts = maxAttempts;
        this.maxNumber = maxNumber;
        this.attempts = 0;
        this.guessedCorrectly = false;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void startGame() {
        // Create a random number between 1 and maxNumber
        Random random = new Random();
        randomNumber = random.nextInt(maxNumber) + 1;

        // Welcome message
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I have generated a random number between 1 and " + maxNumber + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");
    }

    @Override
    public void makeGuess(int guess) {
        attempts++;

        // Check if the guess is correct or not
        if (guess < randomNumber) {
            System.out.println("Too low! Try again.");
        } else if (guess > randomNumber) {
            System.out.println("Too high! Try again.");
        } else {
            guessedCorrectly = true;
            System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        }
    }

    @Override
    public void endGame() {
        if (attempts >= maxAttempts && !guessedCorrectly) {
            System.out.println("Sorry, you've run out of attempts! The correct number was " + randomNumber + ".");
        }
    }

    // Method to play the game interactively
    public void play() {
        startGame();

        // Loop until the user either guesses correctly or runs out of attempts
        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            makeGuess(userGuess);
        }

        endGame();
    }

    // Close scanner to avoid resource leaks
    public void close() {
        scanner.close();
    }
}
