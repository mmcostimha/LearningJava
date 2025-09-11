
import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("I'm alive!!!");
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        while (9 != opcion){

            //----Menu-----
            System.out.println("Make your choice:");
            System.out.println("1 - Rectangle area (Print)");
            System.out.println("2 - Roll the Dice (Random)");
            System.out.println("3 - Hypotenuse (Math)");
            System.out.println("4 - Compound interest calculator(Math)");
            System.out.println("5 - Pass or Fail(Ternary operator)");
            System.out.println("6 - Rock Paper Scissors (1D and 2D Arrays)");
            System.out.println("...");
            System.out.println("...");
            System.out.println("9 - Leave");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1->
                    Hello(scanner);
                case 2->
                    RollDice(scanner);
                case 3->
                    Maths(scanner);
                case 4->
                    CompoundInterest(scanner);
                case 5->
                    PassFail(scanner);
                case 6 ->
                    RockPaperScissors(scanner);
                case 9->
                    System.out.println("Bye");
                default->
                    System.out.println("Unexpected value: " + opcion);
            }
        }
       scanner.close();
    }

    public static void Hello(Scanner scanner){

        System.out.println("Insert the width: ");
        double width = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Insert the height: ");
        double height = scanner.nextDouble();
        scanner.nextLine();

        double area = width * height;

        System.out.println("The area is: " + area + " m2");
        scanner.nextLine();

    }

    public  static void RollDice(Scanner scanner){

        Random random = new Random();

        int number = random.nextInt(1,7);

        System.out.println("Its number: "+ number);
        scanner.nextLine();

    }

    public  static void Maths(Scanner scanner){
        System.out.println("See Math interactions ");

        System.out.println("First number: ");
        double fisrt = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Secund number: ");
        double secund = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Hypotenuse - C1=first_number and C2=second numebr = " + Math.sqrt(Math.pow(fisrt, 2) + Math.pow(secund,2)));
        scanner.nextLine();

    }

    public static void CompoundInterest(Scanner scanner){

        double principle;
        double rate;
        int timesCompounded = 12;
        int years;
        double amount;

        System.out.println("Principle amount: ");
        principle = scanner.nextDouble();

        System.out.println("Rate(%): ");
        rate = scanner.nextDouble()/100;

        System.out.println("Years: ");
        years = scanner.nextInt();

        amount = principle * Math.pow(1 + rate/ timesCompounded, timesCompounded * years);

        System.out.printf("Amount: %.2f \n", amount);
        scanner.nextLine();


    }

    private static void PassFail(Scanner scanner) {
        System.out.println("Insert your theoretical grade");
        int Tgrade = scanner.nextInt();

        System.out.println("Insert your practical grade");
        int Pgrade = scanner.nextInt();

        String result = (Tgrade * 0.7 + Pgrade * 0.3 > 10) ? "Passed" : "Failed";
        System.out.println("You "+ result);
        scanner.nextLine();
    }

    private static  void RockPaperScissors(Scanner scanner){

        Random random = new Random();
        String[] choices = {"Rock","Paper","Scissors"};
        int playerChoice;
        int botChoice;
        boolean playAgain = true;
        String result = "";

        //Create a matching matrix (player;bot)
        //-----------------------------------------
        //  P\B       "Rock"  "Paper"  "Scissors"
        //"Rock"        D       L        W
        //
        //"Paper"       W       D        L
        //
        //"Scissors"    L       W        D
        //-----------------------------------------
        Character[][] responseTable = {
                {'D','L','W'},
                {'W','D','L'},
                {'L','W','D'}
        };

        while (playAgain){
            int i=0;
            // Ask for player response
            System.out.println("Insert your choice");
            for(;i < choices.length; i++)
                System.out.println((i+1) + " - " + choices[i]);

            playerChoice = scanner.nextInt();

            // Generate a Bot response
            botChoice = random.nextInt(0,3);

            //Calculate the result
            switch (responseTable[playerChoice-1][botChoice]){
                case 'D'-> result = "Draw";
                case 'L'->{
                    playAgain=false;
                    result = "You Lose";
                }
                case 'W'->{
                    playAgain=false;
                    result = "You Win";
                }
            }
            System.out.printf("%s(you) VS %s(bot)\n",choices[playerChoice],choices[botChoice]);

            System.out.println(result);
        }
        System.out.println("Nice Game!!!");
        scanner.nextLine();
    }
}
