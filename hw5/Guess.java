import java.util.*;

public class Guess {
   public static final int limit = 100;
   public static void main (String [] args ) {
      Scanner console = new Scanner(System.in);
      printIntro();
      int numGames = 1;
      int totalGuesses = 0;
      int miniGuesses = 9999;
      boolean play = true;
      while (play) {
         int numGuesses = guessGame();
         totalGuesses = totalGuesses + numGuesses;
         miniGuesses = Math.min(miniGuesses,numGuesses);
         System.out.print ("Do you want to play again? ");
         String S = console.next();
         if (S.toUpperCase().startsWith("Y")) {
            play = true;
            numGames++;
         } else {
            play = false;
            results(numGames, numGuesses, totalGuesses, miniGuesses);
         }
      }
   }
   
   //a method introduce the game to user
   public static void printIntro() {
      System.out.println(
      "This program allows you to play a guessing game. \nI will think of a number between 1 and \n" + limit + " and will allow you to guess until \nyou get it.  For each guess, I will tell you \nwhether the right answer is higher or lower \nthan your guess.");
   }
   
   //a method to play one game with user
   public static int guessGame() {
      //int randomNumber = 42; //test use only
      // get random number from 0 - limit
      Random rand = new Random();
      int randomNumber = rand.nextInt(limit + 1);
      
      Scanner console = new Scanner (System.in);
      System.out.println("\nI'm thinking of a number between 1 and " + limit + "...");
      System.out.print("Your guess? ");
      int guess = console.nextInt();
      int numGuesses = 1;
      
      //show hint until correct guess is reached and count how many guesses during the play
      while (guess != randomNumber) {
         if (guess > randomNumber) {
            System.out.println("It's lower.");
         } else {
            System.out.println("It's higher.");
         }
         System.out.print("Your guess? ");
         guess = console.nextInt();
         numGuesses++;
      }
      if (numGuesses > 1) {
      System.out.println("You got it right in " + numGuesses + " guesses");
      } else {
      System.out.println("You got it right in " + numGuesses + " guess");
      }
      return numGuesses;
   }
   
   // a method report overal results to user
   public static void results(int numGames, int numGuesses, int totalGuesses, int miniGuesses) {
      System.out.println("\nOverall results:");
      System.out.println("    total games   = " + numGames);
      System.out.println("    total guesses = " + totalGuesses);
      System.out.println("    guesses/game  = " + round1((double)totalGuesses / (double)numGames));
      System.out.println("    best game     = " + miniGuesses);
   }
   
   // returns the result of rounding n to 1 digit after the decimal point
   public static double round1(double n) {
      return Math.round(n * 10.0) / 10.0;
   }
}