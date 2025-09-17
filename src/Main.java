
import Discography.*;
import AlarmClock.*;
import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Random;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        System.out.println("I'm alive!!!");
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        while (10 != option){

            //----Menu-----
            System.out.println("Make your choice:");
            System.out.println("1 - Rectangle area (Print)");
            System.out.println("2 - Roll the Dice (Random)");
            System.out.println("3 - Hypotenuse (Math)");
            System.out.println("4 - Compound interest calculator(Math)");
            System.out.println("5 - Pass or Fail(Ternary operator)");
            System.out.println("6 - Rock Paper Scissors (1D and 2D Arrays)");
            System.out.println("7 - Write and Read File (Write and Read a file, try, catch and finally)");
            System.out.println("8 - Discography (Classes, Interface and ArrayList)");
            System.out.println("9 - Shut down Timer(Threading)");
            System.out.println("10 - Leave");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
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
                case 7 ->
                    Files(scanner);
                case 8 ->
                    Discography(scanner);
                case 9 ->
                    alarmClock(scanner);
                case 10->
                    System.out.println("Bye");
                default->
                    System.out.println("Unexpected value: " + option);
            }
            System.out.println("Back to menu");
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
        double first = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Secund number: ");
        double secund = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Hypotenuse - C1=first_number and C2=second number = " + Math.sqrt(Math.pow(first, 2) + Math.pow(secund,2)));
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
        int T_grade = scanner.nextInt();

        System.out.println("Insert your practical grade");
        int P_grade = scanner.nextInt();

        String result = (T_grade * 0.7 + P_grade * 0.3 > 10) ? "Passed" : "Failed";
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
    private static  void Files(Scanner scanner){

        //How to write a file using JAVA (4 popular options)
        System.out.println("What you want to write?");
        String text = scanner.nextLine();

        try(FileWriter writer = new FileWriter("test.txt")){
            writer.write(text);

            System.out.println("File was been written");

        }
        catch (IOException e){

            System.out.println("Something went rong");
        }


        System.out.println("See all the info saved:");
        try(BufferedReader reader = new BufferedReader(new FileReader("test.txt"))){

            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        scanner.nextLine();
    }
    private static void Discography(Scanner scanner){

        Discography discography = new Discography();
        ArrayList<PlayList> playLists= new ArrayList<>();

        boolean leave = false;

        while(!leave){

            System.out.println("-----Menu------");
            System.out.println("1 - Create a playList");
            System.out.println("2 - Add a Song to the playList");
            System.out.println("3 - Delete a song from a playList");
            System.out.println("4 - Show the playList");
            System.out.println("5 - Show all playLists");
            System.out.println("6 - Delete a playList");
            System.out.println("7 - Play a playList");
            System.out.println("8 - Show Discography");
            System.out.println("9 - Leave");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1 -> createPlayList(scanner,playLists);
                case 2 -> addDiscoPlayList(scanner, playLists, discography);
                case 3 -> System.out.println("3 - Delete a song from a playList");
                case 4 -> showPlayList(scanner,playLists);
                case 5 -> showPlayLists(playLists);
                case 6 -> System.out.println("6 - Delete a playLis");
                case 7 -> playPlayList(scanner,playLists);

                case 8 -> discography.showDiscography();
                case 9 -> {
                    leave = true;
                    System.out.println("Ty for listen to our music");
                }

                default -> System.out.println("Invalid choice. Chose a valid one.");
            }
        }
        scanner.nextInt();
    }
    private static void createPlayList(Scanner scanner, ArrayList<PlayList> playLists){

        System.out.print("Name of the Playlist: ");
        String name = scanner.nextLine();

        PlayList p = new PlayList(name);
        playLists.add(p);
        System.out.println("PlayList created: " + p.getId());

    }
    private static void showPlayLists(ArrayList<PlayList> playLists){

        System.out.println("--------Play Lists--------");
        for (PlayList pl : playLists){
            System.out.println(pl.getId() +" - PlayList "+ pl.getName() + ":");
        }
        System.out.println("---------------------------");
    }
    private static void addDiscoPlayList(Scanner scanner, ArrayList<PlayList> playLists, Discography d){

        d.showDiscography();

        System.out.print("Songs's Id: ");
        int discoId = scanner.nextInt();
        scanner.nextLine();

        showPlayLists(playLists);

        System.out.print("PlayList's Id: ");
        int playListId = scanner.nextInt();
        scanner.nextLine();

        PlayList pl = getPlById(playListId, playLists);
        Disco disco = d.getDiscoById(discoId);

        if(pl != null && disco!=null)
            pl.addDisco(disco);
        else
            System.out.println("-Disco and Playlist doesn't exist-");


    }
    private static void showPlayList(Scanner scanner, ArrayList<PlayList> playLists){
        showPlayLists(playLists);
        System.out.print("PlayList's Id: ");
        int playListId = scanner.nextInt();
        scanner.nextLine();

        PlayList pl = getPlById(playListId,playLists);
        if (pl != null)
            pl.showPlayList();
    }
    private static PlayList getPlById(int id, ArrayList<PlayList> playLists){

        for (PlayList pl : playLists){
            if(pl.getId() == id){
                return pl;
            }
        }
        return null;
    }
    private static void playPlayList(Scanner scanner, ArrayList<PlayList> playLists){
        showPlayLists(playLists);

        System.out.print("PlayList's Id: ");
        int playListId = scanner.nextInt();
        scanner.nextLine();

        PlayList pl = getPlById(playListId,playLists);
        if (pl != null)
            pl.playPlayer(scanner);
        else
            System.out.print("PlayList doesn't exist");
    }

    private  static void alarmClock(Scanner scanner){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;

        // Get alarm clock time
        while (alarmTime == null){

            try{
                System.out.println("Enter an alarm time (HH:mm:ss)");
                String inputTime = scanner.nextLine();
                alarmTime = LocalTime.parse(inputTime,formatter);
                System.out.println("Alarm set for " + alarmTime);
            }
            catch (DateTimeParseException e){
                System.out.println("Invalid format.");

            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
    }
}
