public class Board {
    public static String[][] boardArray;
    static boolean ballFound = false;
    public static int[] findBall() {
        boardArray = new String[Main.board.length][];
        int[] whiteBallPos = new int[2];
        for (int i = 0; i < Main.board.length; i++) {
            boardArray[i] = Main.board[i].split(" ");
            for (int j = 0; j < boardArray[i].length; j++) {
                if (boardArray[i][j].equals("*")) {
                    whiteBallPos[0] = i;
                    whiteBallPos[1] = j;
                    ballFound = true;
                    break;
                }
            }
        }
        if (ballFound){
            return whiteBallPos;
        }
        return null;
    }
    public static void showBoard(){
        for (String[] strings : boardArray) {
            for (String string : strings) Io.writeToFile("output.txt", (string + " "), true, false);
            Io.writeToFile("output.txt", "", true, true);
        }
    }
}