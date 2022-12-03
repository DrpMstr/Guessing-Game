// Name: NAthan Murdoch
// Class: CS 145
// Assignment: module 1, Guessing Game improvement
// Date: 9/13/22
// Purpose: improve on your lab 4 from cs-145
// Notes: I added prizes at the end based on the number of tries. The rest should be the same.

import java.util.Scanner;//imports scanner
import java.util.Random;//imports a random number generator

public class NMGuessRemasteredLab1 {//start class

   public static void main(String[] args) {//start of main method
   
      Scanner input = new Scanner(System.in);//creates a scanner input
      
      Random rand = new Random();//creates a random input
      
      //initializing variables
      int answer;
      int gameCount = 0;
      int totalGuessCount= 0;
      int bestGuess = 1000000;
      int numTries = 0;
      int UPRANDLIM = 101;
      int guess = 0;
      int random = 0;
      int amountCarWon = 0;
      int amountBikeWon = 0;
      int amountCandyWon = 0;
      
      instructions();
      
      //prompt the user for input and obtain value from user
      System.out.print("Would you like to play the guessing game? 1 for yes, 2 for no: ");
      answer = input.nextInt();
      
      while (answer == 1) {//yes answer
         numTries = playGame(random, guess, numTries, input, rand, UPRANDLIM, totalGuessCount, bestGuess);
         totalGuessCount += numTries;
         if (numTries < bestGuess) {// sets bestGuess if it is greater than the number of tries
         bestGuess = numTries;
         }// end if
         if (numTries == 1) {//beat game in one try
         amountCarWon++;
         } if (numTries == 2 || numTries == 3) {//beat game in 2 or 3 tries
         amountBikeWon++;
         } else {
         amountCandyWon = amountCandyWon + 2;
         }
         //prompt the user for input and obtain value from user
         System.out.print("Would you like to continue playing the guessing game? 1 for yes, 2 for no: ");
         answer = input.nextInt();
         numTries = 0;//resets numTries after everything
         gameCount++;
      }//end while loop
      
      summary(totalGuessCount, bestGuess, gameCount, amountCarWon, amountBikeWon, amountCandyWon);
      
   }//end main method
   
   public static void instructions() {
      System.out.println("Hello and welcome to the Guessing Game!!");//tells you how to play the game
      System.out.println("How this game works is simple, the game will generate a integer between 1 and 100, then you will guess with an integer!");
      System.out.println("Isn't that simple?");
      System.out.println("There may even be a prize at the end!");
      //new car if 1 try, bike for 2nd and 3rd try, and a candy for all of the other tries
   }//end instructions method
   
   public static int playGame(int random, int guess, int numTries, Scanner input, Random rand, int UPRANDLIM, int totalGuessCount, int bestGuess) {
      //creates random number to guess
      random = rand.nextInt(UPRANDLIM + 1);
      while (random != guess) {
      System.out.print("What is your guess?");//get guess
      guess = input.nextInt();
      // get number and assign to guess
         if (guess > random && guess <= (random + 5)) {//gives a hint when guess is within 5 digits above random
            System.out.println("You're close! Try a lower number this time.");
            numTries++;
            } else if (guess > random) {
               System.out.println("Incorrect, try a lower number this time.");
               numTries++;
            //end embedded if
            } else if (guess < random && guess >= (random - 5)) {//gives hint when guess is within 5 digits below random
               System.out.println("You're close! Try a higher number this time.");
               numTries++;
            } else if (guess < random) { 
               System.out.println("Incorrect, try a higher number this time.");
               numTries++;
            } else { 
               numTries++;
               if (numTries == 1) {
               System.out.printf("YOU GOT IT IN %d TRY!! NICE JOB!%n", numTries);
               System.out.print("HERE IS YOUR PRIZE! A NEW CAR!!");
               printCar();
               System.out.println("====================================");
               } else if (numTries == 2 || numTries == 3) {
               System.out.printf("YOU GOT IT IN %d TRIES!! NICE JOB!%n", numTries);
               System.out.println("HERE IS YOUR PRIZE! A NEW BIKE!!");
               printBike();
               System.out.println("====================================");
               } else {
               System.out.printf("YOU GOT IT IN %d TRIES!! NICE JOB!%n", numTries);
               System.out.println("YOU NOW GET SOME CANDY!! the best prize, honestly");
               System.out.println("       >o<  --o      ");
               System.out.println("====================================");
               }//ends embed else
            }// end else
      }// end while
      return numTries;
   }//end playGame method
   
   public static void printCar() { //car
   System.out.printf("%n%s%n%s%n%s%n%s%n%s%n%s%n", "          ___________", "         |     |     \\ ", "________/|_____|______\\_______", "|  ___   |_    |_    |  ___  ||", "\\_|\\_/|__|_____|_____|_|\\_/|_/", "    O                    O");
  //                ___________
  //               |     |     \
  //      ________/|_____|______\_______      car picture
  //      |  ___   |_    |_    |  ___  ||
  //      \_|\_/|__|_____|_____|_|\_/|_/
  //          O                    O   
   }//end printCar method
   
   public static void printBike() {//bike
   
   System.out.printf("%n%s%n%s%n%s%n%s%n", "        ___  --|--", "       ___|____|", "      /____/   \\", "     O          O");
   //        ___  --|--
   //       ___|____|
   //      /____/   \         bike picture
   //     O          O
   }//end printBike method
   
   public static void summary(int totalGuessCount, int bestGuess, int gameCount, int amountCarWon, int amountBikeWon, int amountCandyWon) {//displays some stats
      System.out.printf("Total Guesses: %d%n", totalGuessCount);//displays total guesses
      System.out.printf("Average Guess Count: %d%n", (totalGuessCount / gameCount));// displays average guess count
      System.out.printf("Best Guess: %d%n", bestGuess);//displays best guess
      System.out.printf("Total Games Played: %d%n", gameCount);//displays total games played
      System.out.printf("Cars Won: %d%n", amountCarWon);//displays total cars won
      System.out.printf("Bikes Won: %d%n", amountBikeWon);//displays total bikes won
      System.out.printf("Candy Won: %d%n", amountCandyWon);//displays amount of candy won
   }// end summary method
}//end class