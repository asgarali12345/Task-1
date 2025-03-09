import java.util.*;

public class codsoftTask1{
    public static void main(String args[]){
        int totalScore=0;
        boolean playAgain=true;
        Scanner sc=new Scanner(System.in);
        
        while(playAgain){
            int attemptsToken=playRound(sc);
            if(attemptsToken!=-1){
                totalScore+=(10-attemptsToken);
            }
            System.out.println("\nDo you want to play another round? (yes/no)");
            String playAgainInput=sc.next().toLowerCase();

            if(!playAgainInput.equals("yes")){
                playAgain=false;
            }
        }

        System.out.println("\nYour total score is : "+totalScore);
        System.out.println("Thanks for playing!");
        sc.close();
    }

    public static int playRound(Scanner sc){
        Random random=new Random();
        int targetNumber=random.nextInt(100)+1;
        int attempts=0;
        int maxAttempts=10;

        System.out.println("\nI have selected a random number between 1 and 100.");
        System.out.println("You have "+maxAttempts+" attempts to guess the number.");
        
        while(attempts<maxAttempts){
            attempts++;
            System.out.println("Attempts "+attempts+" : Enter your guess : ");
            int guess=sc.nextInt();

            if(guess<targetNumber){
                System.out.println("To low! try again.");
            }else if(guess>targetNumber){
                System.out.println("Too high! try again.");
            }else{
                System.out.println("Correct! the number was "+targetNumber+". You guessed it in "+attempts+" attempts.");
                return attempts;
            }
        }
        System.out.println("Sorry you have used all "+maxAttempts+ " attempts. The correct number was "+targetNumber+".");
        return -1;
    }
}

