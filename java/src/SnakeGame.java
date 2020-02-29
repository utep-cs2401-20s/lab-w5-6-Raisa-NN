public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame() {
        game = new boolean[1][1];
    }

    public SnakeGame(boolean[][] game, int x, int y) {
        //this.game = new boolean[game.length][game[0].length];
        for (int i = 0; i < game.length; i++) {
            for (int k = 0; k < game.length; k++) {
                this.game[i][k] = game[i][k];
            }
        }
        this.headPosition = new int[2];
        headPosition[0] = x;
        headPosition[1] = y;
    }


    private void resetCounters() {
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    public static int getExhaustiveChecks() { //Static because it should return same value no matter where it is called
        return exhaustiveChecks;
    }

    public static int getRecursiveChecks() {//Changed to public so that it can be accessed in SnakeGameTester.java
        return recursiveChecks;
    }

    public int neighbours(int row, int col) { //Helper method to count the 4 possible neighbours
        int neighbour = 0;
        if (game[row][col + 1] && col + 1 < game.length) { //If right neighbour is a snake and is in the board
            neighbour++;
        }
        if (game[row + 1][col] && row + 1 < game.length) { //If bottom neighbour is a snake and is in the board
            neighbour++;
        }
        if (game[row - 1][col] && row - 1 >= 0) { //If top neighbour is a snake and is in the board
            neighbour++;
        }
        if (game[row][col - 1] && col - 1 >= 0) { //If left neighbour is a snake and is in the board
            neighbour++;
        }
        return neighbour;
    }

    public int[] findTailExhaustive() {
        resetCounters();
        int[] result = new int[3];
        int tailX = 0;
        int tailY = 0;
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                int sumNeighbours = neighbours(i, j); //Calling neighbours method to count number of neighbours and see if cell is a head/tail or none
                if (sumNeighbours == 1) { // Checking to see if cell is a head/tail
                    if (!game[headPosition[0]][headPosition[1]]) { //If the cell is tail. That is, if tail found
                        tailX = i;
                        tailY = j;
                    } else {
                        exhaustiveChecks++;
                    }
                }
            }
        }
        return result = new int[]{tailX, tailY, findLength()};
    }

    public int[] findTailRecursive() {
        resetCounters();
        int[] result = findTailRecursive(headPosition, headPosition);
        return result;
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {
        resetCounters();
        recursiveChecks++;
        //if going up
        if (currentPosition[0] - 1 >= 0) { //if spot is in board
            if (game[currentPosition[0] - 1][currentPosition[1]]) { //If top neighbour is a snake
                if (currentPosition[0] - 1 != previousPosition[0] && currentPosition[1] - 1 != previousPosition[1]) { //If spot is not previous
                    int[] newPos = new int[]{currentPosition[0] - 1, currentPosition[1]};
                    return findTailRecursive(newPos, currentPosition);
                }
            }
        }
        //if going down
        if (currentPosition[0] + 1 >= 0) { //if spot is in board
            if (game[currentPosition[0] + 1][currentPosition[1]]) { //If bottom neighbour is a snake
                if (currentPosition[0] + 1 != previousPosition[0] && currentPosition[1] + 1 != previousPosition[1]) { //If spot is not previous
                    int[] newPos = new int[]{currentPosition[0] + 1, currentPosition[1]};
                    return findTailRecursive(newPos, currentPosition);
                }
            }
        }
        //going left
        if (currentPosition[1] - 1 < game.length) { //if spot is in board
            if (game[currentPosition[0]][currentPosition[1] - 1]) { //If left neighbour is a snake
                if (currentPosition[0] - 1 != previousPosition[0] && currentPosition[1] - 1 != previousPosition[1]) { //if spot is not previous
                    int[] newPos = new int[]{currentPosition[0], currentPosition[1] - 1};
                    return findTailRecursive(newPos, currentPosition);
                }
            }
        }
        //going right
        if (currentPosition[1] + 1 < game.length) { //if spot is in board
            if (game[currentPosition[0]][currentPosition[1] + 1]) { //If right neighbour is a snake
                if (currentPosition[0] != previousPosition[0] && currentPosition[1] + 1 != previousPosition[1]) { //if spot is not previous
                    int[] newPos = new int[]{currentPosition[0], currentPosition[1] + 1};
                    return findTailRecursive(newPos, currentPosition);
                }
            }
        }
        if (neighbours(currentPosition[0], currentPosition[1]) == 1) { //Base case
            if (headPosition[0] != currentPosition[0] && headPosition[1] != currentPosition[1]) {
                return new int[]{currentPosition[0], currentPosition[1], findLength()};
            }
        }
        return new int[]{currentPosition[0], currentPosition[1], findLength()};
    }
    public int findLength() { //Helper method to find the length
        int length = 0;
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j]) { //If part of snake
                    length++;
                }
            }
        }
        return length;
    }
}
