import java.util.Arrays;
public class Move {
    public static void score(String movePosition) {
        switch (movePosition) {
            case "R":
                Main.score += 10;
                Board.boardArray[Main.ball[0]][Main.ball[1]] = "X";
                break;
            case "Y":
                Main.score += 5;
                Board.boardArray[Main.ball[0]][Main.ball[1]] = "X";
                break;
            case "B":
                Main.score -= 5;
                Board.boardArray[Main.ball[0]][Main.ball[1]] = "X";
                break;
        }
    }


    public static void moveCalculator(int rowChange, int columnChange){
        int[] previousBallPosition = Arrays.copyOf(Main.ball, Main.ball.length);
        if (Main.ball[0] == 0 && rowChange == -1){
            Main.ball[0] = Board.boardArray.length-1;
        }

        else if (Main.ball[0] == Board.boardArray.length-1 && rowChange == 1){
            Main.ball[0] = 0;
        }

        else if (Main.ball[1] == Board.boardArray[0].length && columnChange == -1){
            Main.ball[1] = Board.boardArray[0].length-1;
        }
        else if (Main.ball[1] == Board.boardArray[0].length-1 && columnChange == 1){
            Main.ball[1] = 0;
        }

        else{
            Main.ball[0] += rowChange;
            Main.ball[1] += columnChange;
        }

        if (Board.boardArray[Main.ball[0]][Main.ball[1]].equals("H")){
            Board.boardArray[previousBallPosition[0]][previousBallPosition[1]] = " ";
            Main.stop = true;
        }

        else {
            score(Board.boardArray[Main.ball[0]][Main.ball[1]]);
            String temp = Board.boardArray[Main.ball[0]][Main.ball[1]];
            Board.boardArray[Main.ball[0]][Main.ball[1]] = "*";
            Board.boardArray[previousBallPosition[0]][previousBallPosition[1]] = temp;
        }
    }


    public static void moveCalculation(String move) { /*This part checks if there is a wall in the direction
    the ball will go next.If there is a wall, it reverses the input (for example, the input to go left was
    entered and if there is a wall, it goes to the right.) I used 3 nested ifs to solve this because there may
    be a wall in the direction the ball will go if it goes outside the board and at the very edge.*/
        if (move.equals("L")) {
            if (Main.ball[1] == 0){
                if (Board.boardArray[Main.ball[0]][Board.boardArray[0].length-1].equals("W")) moveCalculator(0,1);
            }
            else if (Board.boardArray[Main.ball[0]][Main.ball[1]-1].equals("W")) moveCalculator(0,1);
            else moveCalculator(0,-1);
        }

        if (move.equals("R")) {
            if (Main.ball[1] == Board.boardArray[0].length-1){
                if (Board.boardArray[Main.ball[0]][0].equals("W")) moveCalculator(0,-1);
            }
            else if (Board.boardArray[Main.ball[0]][Main.ball[1]+1].equals("W")) moveCalculator(0,-1);
            else moveCalculator(0,1);
        }

        if (move.equals("U")) {
            if (Main.ball[0] == 0){
                if (Board.boardArray[Board.boardArray.length-1][Main.ball[1]].equals("W")) moveCalculator(1,0);
            }
            else if (Board.boardArray[Main.ball[0]-1][Main.ball[1]].equals("W")) moveCalculator(1,0);
            else moveCalculator(-1,0);
        }

        if (move.equals("D")) {
            if (Main.ball[0] == Board.boardArray.length-1){
                if (Board.boardArray[0][Main.ball[1]].equals("W")) moveCalculator(-1,0);
            }
            else if (Board.boardArray[Main.ball[0]+1][Main.ball[1]].equals("W")) moveCalculator(-1,0);
            else moveCalculator(1,0);
        }
    }
}