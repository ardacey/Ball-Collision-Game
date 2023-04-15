import java.util.Arrays;
public class Main {
    static int score,moveCounter = 0;
    static int[] ball;
    static boolean stop = false;
    static String[] move, moveArray, board;
    public static void main(String[] args) {

        board = Io.readFile(args[0], false, false);
        move = Io.readFile(args[1], false, false);
        assert Main.move != null;
        moveArray = Main.move[0].split(" ");

        Io.fileCleaner(); //Clears output.txt, creates it if it doesn't exist.
        ball = Board.findBall(); //finds ball's position.
        Io.writeToFile("output.txt","Game board:",true,true);
        Board.showBoard();

        for (String s : moveArray) {
            Move.moveCalculation(s);
            moveCounter += 1;
            if (stop){
                for (int i = moveCounter; i < moveArray.length; i++) moveArray[i] = ""; //deleting moves after hole
                break;
            }
        }

        Io.writeToFile("output.txt","\nYour movement is:",true,true);
        String moveString = Arrays.toString(moveArray)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        Io.writeToFile("output.txt", moveString, true, true);
        Io.writeToFile("output.txt","\nYour output is:",true,true);
        Board.showBoard();
        if (stop) Io.writeToFile("output.txt","\nGame Over!",true,false);
        Io.writeToFile("output.txt","\nScore: " + score,true,false);
    }
}