import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

  public static void main(String[] args) {
    System.out.println("---------------------------------");
    System.out.println("------Rock, Paper, Scissors------");
    System.out.println("---------------------------------");

    playGame();
  }

  public static void playGame() {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int score = 0; // track player score

    while (true) {
      System.out.print("Enter your choice (rock, paper, scissors or quit): ");
      String userChoice = scanner.nextLine().toLowerCase();

      if (userChoice.equals("quit")) {
        System.out.println("Thanks for playing! Final Score: " + score);
        break; // exit the loop
      }

      if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
        System.out.println("Invalid choice. Try again.");
        continue; // restart loop
      }

      String[] choices = { "rock", "paper", "scissors" };
      String computerChoice = choices[random.nextInt(choices.length)];

      System.out.println("Computer chose: " + computerChoice);

      String result;
      if (userChoice.equals(computerChoice)) {
        result = "It's a tie!";
      } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
          (userChoice.equals("paper") && computerChoice.equals("rock")) ||
          (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
        result = "You win!";
        score++; // increase score
      } else {
        result = "Computer wins!";
        if (score > 0) { // prevent negative score
          score--;
        }
      }

      System.out.println(result);
      System.out.println("Current Score: " + score);
      System.out.println("---------------------------------");
    }

    scanner.close();
  }
}
