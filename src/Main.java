import java.util.Arrays;

public class Main {
    static int score;
    static int moveCounter;
    static int[] ball;
    static boolean stop;
    static String[] move;
    static String[] moveArray;
    static String[] board;
    static String outputPath;

    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("Usage: java -cp src Main <board-file> <move-file> [output-file]");
            return;
        }

        board = Io.readFile(args[0], false, false);
        move = Io.readFile(args[1], false, false);
        outputPath = args.length == 3 ? args[2] : "output.txt";

        if (board == null || move == null || move.length == 0) {
            System.err.println("Could not read input files.");
            return;
        }

        moveArray = move[0].trim().split("\\s+");

        Io.fileCleaner(outputPath);
        ball = Board.findBall();

        if (ball == null) {
            System.err.println("Board does not contain a ball marker '*'.");
            return;
        }

        Io.writeToFile(outputPath, "Initial board:", true, true);
        Board.showBoard();

        for (String direction : moveArray) {
            Move.moveCalculation(direction);
            moveCounter += 1;
            if (stop) {
                for (int i = moveCounter; i < moveArray.length; i++) {
                    moveArray[i] = "";
                }
                break;
            }
        }

        Io.writeToFile(outputPath, "\nMoves:", true, true);
        String moveString = Arrays.toString(moveArray)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        Io.writeToFile(outputPath, moveString.trim(), true, true);

        Io.writeToFile(outputPath, "\nFinal board:", true, true);
        Board.showBoard();

        if (stop) {
            Io.writeToFile(outputPath, "\nResult: Game Over", true, false);
        }

        Io.writeToFile(outputPath, "\nScore: " + score, true, false);
    }
}
