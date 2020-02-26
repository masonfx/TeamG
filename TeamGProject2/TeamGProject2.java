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
        boolean gameRepeater = true; //used to repeat just the game until the user reaches or exceeds $1.00
        double userBalance = 0; //initializing variable to track the user's balance for the game
        Scanner userInput = new Scanner (System.in); //scanner for user input within playTheGame function
        String userSelection; //variable to hold scanner input
        double coinWorth = 0; //tracks how much the current coin is worth
        headsOrTails randomChance = new headsOrTails(); //headsOrTails object to randomly generate result

        do
        {
            System.out.println("Which coin would you like to toss?\n1. Penny\n2. Nickel\n3. Dime\n4. Quarter\n5. Exit to Menu");
            userSelection = userInput.nextLine();

            while (!userSelection.equals("1") && !userSelection.equals("2") && !userSelection.equals("3") && !userSelection.equals("4") && !userSelection.equals("5")) //validating user input
            {
                System.out.println("Please input a valid selection of 1, 2, 3, or 4.");
                userSelection = userInput.nextLine();
            }

            switch (userSelection) { //Determines what coin the user selected and calls the appropriate class to assign a value
                case "1":
                    coinWorth = pennyCoin.setWorth();
                    break;
                case "2":
                    coinWorth = nickelCoin.setWorth();
                    break;
                case "3":
                    coinWorth = dimeCoin.setWorth();
                    break;
                case "4":
                    coinWorth = quarterCoin.setWorth();
                    break;
                default: //if the user selects to exit the program, this changes the boolean running the program to exit
                    gameRepeater = false;
            }

            if (randomChance.flipTheCoin() == 1 && !userSelection.equals("5")) //if the randomly generated number equals 1, that means true
            { //the !userSelection.equals("5") ensures the following does not print if the user selects to exit to menu
                userBalance += coinWorth;
                System.out.println("Heads!\nYour Balance is now: $" + userBalance);
            } else if (randomChance.flipTheCoin() == 0 && !userSelection.equals("5")) //if the randomly generated number equals 0, that means false
            {
                System.out.println("Tails!\nYour Balance is still: $" + userBalance);
            }

            if (userBalance == 1) //if the user reaches $1, they win
            {
                System.out.println("Congratulations! You win the game!");
                gameRepeater = false;
            } else if (userBalance > 1) //if the user exceeds $1, they lose
            {
                System.out.println("Unfortunately, you've lost. You went over $1.00!");
                gameRepeater = false;
            }
        } while (gameRepeater); //end of do/while loop that repeats the game
    } //end of playTheGame method

} //end of class TeamGProject2