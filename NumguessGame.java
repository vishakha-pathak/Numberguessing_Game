import java.util.Random;
import java.util.Scanner;

public class NumguessGame
 {
    public static void main(String args[]) 
     {
       Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        boolean exitGame = false;
        int level = 1;

        while (!exitGame) 
          {
            System.out.println("\nLevel " + level);
            int maxRange = 100 + (level - 1) * 50;         // Increase range by 50 with each level
            System.out.println("I have selected a number between 1 and " + maxRange + ".");
            int maxAttempts = 11 - level;                    // Decrease attempts with each level
            if (maxAttempts < 1) 
            {
                maxAttempts = 1;
            }
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            boolean levelComplete = false;

            while (!levelComplete) 
             {
                // Generate a random number between 1 and maxRange
                Random random = new Random();
                int randomNumber = random.nextInt(maxRange) + 1;

                int attempts = 0;
                boolean hasWon = false;

                while (attempts < maxAttempts) 
                 {
                    System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                    int playerGuess = scanner.nextInt();
                    attempts++;

                    if (playerGuess == randomNumber) 
                   {
                        hasWon = true;
                        break;
                    } 
                     else if (playerGuess < randomNumber)
                    {
                        System.out.println("Too low! Try again.");
                    } 
                    else 
                     {
                        System.out.println("Too high! Try again.");
                    }
                }

                if (hasWon) 
                 {
                    System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                    level++;
                    levelComplete = true;
                } 
                 else 
                {
                    System.out.println("Sorry, you've used all attempts. The correct number was: " + randomNumber);
                    System.out.print("Do you want to replay this level? (yes/no): ");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("no")) 
                  {
                        exitGame = true;
                        levelComplete = true;
                    }
                }
            }

            if (!exitGame) 
             {
                System.out.print("Do you want to continue to the next level? (yes/no): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("no")) 
                {
                    exitGame = true;
                }
            }
        }

        System.out.println("Thank you for playing the Game!");
        scanner.close();
    }
}
