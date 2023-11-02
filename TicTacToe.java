import java.util.*;

public class TicTacToe {

    public static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    public static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

    //init pole

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
    //tiskneme
        printGameBoard(gameBoard);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your choice(1-9):\n");
            int playerPos = scanner.nextInt();
            // Kontrola, zda hráč nebo CPU již nezaujali danou pozici
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("Position taken! Enter a correct Position");
                playerPos = scanner.nextInt();
            }
            // Umístí hráčovu pozici a aktualizuje seznam hráčových pozic
            placePiece(gameBoard, playerPos, "player");

            // Generuje náhodnou pozici pro CPU a kontroluje, zda je již obsazena
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            // Umístí pozici CPU a aktualizuje seznam pozic CPU
            placePiece(gameBoard, cpuPos, "cpu");

            // Vytiskne aktuální stav herního pole
            printGameBoard(gameBoard);


            // Kontrola vítězství nebo remízy
            String result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
        }
    }

    // Metoda pro tisk herního pole
    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // Metoda pro umístění symbolu hráče nebo CPU na herní pole
    public static void placePiece(char[][] gameBoard, int position, String user) {

        char symbol = ' ';

        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(position);// Přidání pozice hráče do seznamu
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(position);// Přidání pozice CPU do seznamu
        }

        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
    // Metoda pro kontrolu vítězství nebo remízy
    public static String checkWinner() {

        List<List<Integer>> winning = new ArrayList<List<Integer>>();
        winning.add(Arrays.asList(1, 2, 3));
        winning.add(Arrays.asList(4, 5, 6));
        winning.add(Arrays.asList(7, 8, 9));
        winning.add(Arrays.asList(1, 4, 7));
        winning.add(Arrays.asList(2, 5, 8));
        winning.add(Arrays.asList(3, 6, 9));
        winning.add(Arrays.asList(1, 5, 9));
        winning.add(Arrays.asList(3, 5, 7));

        // Kontrola vítězství a remízy
        for (List<Integer> l : winning) {
            if (playerPositions.containsAll(l)) {
                return "Congratz, vyhral si";
            } else if (cpuPositions.containsAll(l)) {
                return "CPU WINS";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "tie";
            }
        }

        return "";
    }
}