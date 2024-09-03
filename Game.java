import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("welcome to the number guessing game!");

        int randomNumber = rand.nextInt(100);
        int input = 0;
        int guess = -1;
        String[] difficulty = { "easy", "medium", "hard" };
        int[] tries = { 10, 5, 3 };

        System.out.println("please select the difficulty level:");

        while (input != 1 && input != 2 && input != 3) {

            System.out.println(
                    "1. easy (10 guesses) \n2. medium (5 guesses) \n3. hard (3 chances) \n\nenter your choice: ");

            try {
                input = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("please only write an integer between 1 and 3");
                scanner.next();
            }
            if(input > 3){
                System.out.println("please only write an integer between 1 and 3");
            }
        }

        System.out.println("you selected " + difficulty[input - 1] + " difficulty \n");
        while (tries[input - 1] >= 0) {
            if (guess == randomNumber) {
                System.out.println(
                        "congratulations! you guessed the correct answer with " + tries[input - 1] + " guesses left");
                break;
            }

            System.out.println("please enter your guess: ");

            try {
                guess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("please only write an integers");
                tries[input - 1]++;
                scanner.next();
            }
            tries[input - 1]--;

            if (guess == randomNumber) {
                System.out.println(
                        "congratulations! you guessed the correct answer with " + tries[input - 1] + " guesses left");
                break;
            } else {
                if (guess > randomNumber) {
                    System.out.println("incorrect, my number is smaller");
                } else {
                    System.out.println("incorrect, my number is larger");
                }
            }
        }
        if (guess != randomNumber) {
            System.out.println("sorry you didnt guess the correct answer, was it was: " + randomNumber);

        }

        scanner.close();
    }
}