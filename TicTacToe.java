import java.util.*;


public class TicTacToe {

    static String board[] = {" ", " ", " ", " ", " ", " ", " ", " ", " "};


    //Nakresli herni pole
    public static void drawBoard(){
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
    }






    public static void main (String [] args){
    drawBoard();
    }
}
