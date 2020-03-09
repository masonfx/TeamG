package TeamGProject2;
import java.util.*;

public class TeamGProject2 {
    public static void main(String[] args)
    {
        boolean masterRepeater = true; //used to repeat the entire program until the user manually exits
        String userSelection; //initializing variable to hold user input for the duration of the program
        Scanner userInput = new Scanner (System.in); //creating scanner to track user input

        System.out.println("Welcome to our Coin Tossing Game!\nThe rules are simple: the goal is to reach $1.00 exactly by flipping various coins.\nSimply select the coin you wish to flip and hope for the best!");
        do //the majority of the program will be located in this do/while loop - set to repeat until the user selects to exit
        {
            System.out.println("Menu:\n1. Play The Game!\n2. Exit");
            userSelection = userInput.nextLine();

            while (!userSelection.equals("1") && !userSelection.equals("2")) //validating user input
            {
                System.out.println("Please input a valid selection of 1 or 2");
                userSelection = userInput.nextLine();
            }

            if (userSelection.equals("1")) //if the user selects to play the game
            {
                playTheGame(); //calls the playTheGame function
            } else { //if the user selects to exit the program
                masterRepeater = false;
                System.out.println("Thank You for Playing!");
            }

        } while (masterRepeater); //end of main repeater

        System.out.println("Exiting the Program..");
        System.exit(0);
    } //end of main method

    public static void playTheGame() //method to run the game
    {
        double userBalance = 0; //initializing variable to track the user's balance for the game
        double coinWorth = 0; //tracks how much the current coin is worth
        headsOrTails randomChance = new headsOrTails(); //headsOrTails object to randomly generate result

        do
        {
            coinWorth = pennyCoin.getWorth();
            if (randomChance.flipTheCoin() == 1)
            {
                userBalance += coinWorth;
                System.out.println("Penny: Heads");
            } else {
                System.out.println("Penny: Tails");
            }

            coinWorth = nickelCoin.getWorth();
            if (randomChance.flipTheCoin() == 1)
            {
                userBalance += coinWorth;
                System.out.println("Nickel: Heads");
            } else {
                System.out.println("Nickel: Tails");
            }

            coinWorth = dimeCoin.getWorth();
            if (randomChance.flipTheCoin() == 1)
            {
                userBalance += coinWorth;
                System.out.println("Dime: Heads");
            } else {
                System.out.println("Dime: Tails");
            }

            coinWorth = quarterCoin.getWorth();
            if (randomChance.flipTheCoin() == 1)
            {
                userBalance += coinWorth;
                System.out.println("Quarter: Heads");
            } else {
                System.out.println("Quarter: Tails");
            }

            System.out.println("Current Balance: $" + userBalance);

            if (userBalance == 1) //if the user reaches $1, they win
            {
                System.out.println("Congratulations! You win the game!");
            } else if (userBalance > 1) //if the user exceeds $1, they lose
            {
                System.out.println("Unfortunately, you've lost. You got $" + userBalance + "!");
            }
        } while (userBalance < 1);

    } //end of playTheGame method

} //end of class TeamGProject2