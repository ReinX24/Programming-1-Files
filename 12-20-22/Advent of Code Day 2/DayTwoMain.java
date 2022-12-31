import java.util.Scanner;

public class DayTwoMain {

    public static void main(String[] args) {

        /*
         * --- Day 2: Rock Paper Scissors ---
         * 
         * The Elves begin to set up camp on the beach. To decide whose tent gets to be
         * closest to the snack storage, a giant Rock Paper Scissors tournament is
         * already in progress.
         * 
         * Rock Paper Scissors is a game between two players. Each game contains many
         * rounds; in each round, the players each simultaneously choose one of Rock,
         * Paper, or Scissors using a hand shape. Then, a winner for that round is
         * selected: Rock defeats Scissors, Scissors defeats Paper, and Paper defeats
         * Rock. If both players choose the same shape, the round instead ends in a
         * draw.
         * 
         * Appreciative of your help yesterday, one Elf gives you an encrypted strategy
         * guide (your puzzle input) that they say will be sure to help you win.
         * "The first column is what your opponent is going to play: A for Rock, B for Paper, and C for Scissors. The second column--"
         * Suddenly, the Elf is called away to help with someone's tent.
         * 
         * The second column, you reason, must be what you should play in response: X
         * for Rock, Y for Paper, and Z for Scissors. Winning every time would be
         * suspicious, so the responses must have been carefully chosen.
         * 
         * The winner of the whole tournament is the player with the highest score. Your
         * total score is the sum of your scores for each round. The score for a single
         * round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3
         * for Scissors) plus the score for the outcome of the round (0 if you lost, 3
         * if the round was a draw, and 6 if you won).
         * 
         * Since you can't be sure if the Elf is trying to help you or trick you, you
         * should calculate the score you would get if you were to follow the strategy
         * guide.
         * 
         * For example, suppose you were given the following strategy guide:
         * 
         * A Y
         * B X
         * C Z
         * 
         * This strategy guide predicts and recommends the following:
         * 
         * In the first round, your opponent will choose Rock (A), and you should choose
         * Paper (Y). This ends in a win for you with a score of 8 (2 because you chose
         * Paper + 6 because you won).
         * In the second round, your opponent will choose Paper (B), and you should
         * choose Rock (X). This ends in a loss for you with a score of 1 (1 + 0).
         * The third round is a draw with both players choosing Scissors, giving you a
         * score of 3 + 3 = 6.
         * 
         * In this example, if you were to follow the strategy guide, you would get a
         * total score of 15 (8 + 1 + 6).
         * 
         * What would your total score be if everything goes exactly according to your
         * strategy guide?
         * 
         * Link to website:
         * https://adventofcode.com/2022/day/2
         * 
         */

        // Scanner object to accept input
        Scanner scanOne = new Scanner(System.in);

        // While loop that runs until 3 rounds are played
        int userScore = 0; // user score
        int roundNum = 1; // round number

        while (roundNum < 4) {

            // Showing round number and choices
            char userChoice = ' '; // for user input
            System.out.println("[Round " + roundNum + "]");
            System.out.println("[Score: " + userScore + "]");
            System.out.println("[X Rock | Y Paper | Z Scissors]");
            System.out.print("Input: ");
            userChoice = scanOne.next().charAt(0); // no charNext in Java

            switch (userChoice) { // adding score depending on answer
                case 'X':
                    userScore += 1; // +1 for Rock
                    break;
                case 'Y':
                    userScore += 2; // +2 for Paper
                    break;
                case 'Z':
                    userScore += 3; // +3 for Scissors
                    break;
            }

            // Checking who won the round

            // If you win +8 to your score (2 for paper, 6 for win)
            // Opponent: A (Rock)
            if (roundNum == 1 && userChoice == 'X') { // If tie (Rock too)
                userScore += 3; // add 3 if tie
                System.out.println("[Tie!]");
            } else if (roundNum == 1 && userChoice == 'Y') { // Round win in first round (Paper)
                userScore += 6; // add 6 if win
                System.out.println("[You win!]");
            } else if (roundNum == 1 && userChoice == 'Z') { // If lose (Scissors)
                System.out.println("[You lose!]");
            }

            // If lose, +1 only to your score (1 for rock)
            // Opponent: B (Paper)
            if (roundNum == 2 && userChoice == 'X') { // Round lose in second round (Rock)
                System.out.println("[You lose!]");
            } else if (roundNum == 2 && userChoice == 'Y') { // If tie (Paper too)
                userScore += 3; // add 3 if tie
                System.out.println("[Tie!]");
            } else if (roundNum == 2 && userChoice == 'Z') { // If player wins (Scissors)
                userScore += 6; // add 6 if the user wins
                System.out.println("[You win!]");
            }

            // If tie, +6 (3 + 3)
            // Opponent: C (Scissors)
            if (roundNum == 3 && userChoice == 'X') { // Round win (Rock)
                userScore += 6;
                System.out.println("[You win!]");
            } else if (roundNum == 3 && userChoice == 'Y') { // Round lose (Paper)
                System.out.println("[You lose!]");
            } else if (roundNum == 3 && userChoice == 'Z') { // Round tie in third round (Scissors)
                userScore += 3; // add 3 if tie
                System.out.println("[Tie!]");
            }

            roundNum++; // increments roundNum after each round

        }

        // Sum should be 15 (8 + 1 + 6)
        System.out.println("User Score: " + userScore);
        scanOne.close(); // closes Scanner

    }

}