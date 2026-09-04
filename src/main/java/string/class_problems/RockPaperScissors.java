package string.class_problems;
import java.util.*;

public class RockPaperScissors {
    static String playRound(String playerMove,String computerMove){
        if(playerMove.equals(computerMove))
            return "Draw";
        if((playerMove.equals("Rock")&&computerMove.equals("Scissors"))||
                (playerMove.equals("Paper")&&computerMove.equals("Rock"))||
                (playerMove.equals("Scissors")&&computerMove.equals("Paper")))
            return "Player Wins";
        return "Computer Wins";
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Random random=new Random();

        String[] moves={"Rock","Paper","Scissors"};
        String[] playerMoves=new String[5];
        String[] computerMoves=new String[5];
        String[] results=new String[5];

        int wins=0,losses=0,draws=0;

        for(int i=0;i<5;i++){
            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            playerMoves[i]=sc.next();

            computerMoves[i]=moves[random.nextInt(3)];
            results[i]=playRound(playerMoves[i],computerMoves[i]);

            if(results[i].equals("Player Wins"))
                wins++;
            else if(results[i].equals("Computer Wins"))
                losses++;
            else
                draws++;

            System.out.println("Round "+(i+1)+" — Player: "+playerMoves[i]+", Computer: "+computerMoves[i]+" "+results[i]);
        }

        double winPercentage=(wins/5.0)*100;

        System.out.println("\nFinal Summary");
        System.out.println("Round\tPlayer Move\tComputer Move\tResult");

        for(int i=0;i<5;i++)
            System.out.println((i+1)+"\t"+playerMoves[i]+"\t\t"+computerMoves[i]+"\t\t"+results[i]);

        System.out.println("\nWins: "+wins+" | Losses: "+losses+" | Draws: "+draws+" | Win % = "+winPercentage+"%");
        sc.close();
    }
}