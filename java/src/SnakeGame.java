public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame() {
        game = new boolean[1][1];
    }

    public SnakeGame(boolean[][] game, int x, int y) {
        this.game = game;//use nested for loop?
        this.headPosition = new int[2];
        headPosition[0] = x;
        headPosition[1] = y;
    }


    private void resetCounters() {
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    private static int getExhaustiveChecks() {//in test cases, make it public; it has to be static because method is static
        return exhaustiveChecks;
    }

    private static int getRecursiveChecks() {
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
        int length = 0;
        int[] result = new int[3];
        int tailX = 0; int tailY = 0;
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                int sumNeighbours = neighbours(i, j); //Calling neighbours method to count number of neighbours and see if cell is a head/tail or none
                if (sumNeighbours == 1) { // Checking to see if cell is a head/tail
                    if (!game[headPosition[0]][headPosition[1]]) { //If the cell is tail. That is, if tail found
                        tailX = i;
                        tailY = j;
                    } else {
                        exhaustiveChecks ++;
                    }
                if (game[i][j]) { //If part of snake
                    length++;
                    }
                }
            }
        }
        return result = new int[]{tailX, tailY, length};
    }

    public int[] findTailRecursive() {
        resetCounters();
        int[] result = findTailRecursive(headPosition, headPosition);
        return result;
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {
        resetCounters();
        recursiveChecks ++;
        int length = 1; //Counts head
        int[] result = new int[3]; //must always go to a cell thathas a snake, count leg=ngth, only increment for calls that has snake
        int tailX = 0; int tailY = 0;
        int sumNeighbours = neighbours(currentPosition[0], currentPosition[1]); //Get the neighbours of head
        if (sumNeighbours == 1 && !game[headPosition[0]][headPosition[1]]) { //If tail (base case)
            return  result = new int[]{headPosition[0], headPosition[1], length};
        }
        if (sumNeighbours >= 1) { // If along snake
            if (game[currentPosition[0]][currentPosition[1] + 1] && currentPosition[1] + 1 < game.length); ////If right neighbour is part of snake and is in the board
            int[] temp = currentPosition;
            currentPosition[0]++;
            currentPosition[1]++;
            previousPosition = temp;
            length++;
            findTailRecursive();
        }
        if (sumNeighbours == 1 && currentPosition != previousPosition) { //If at tail
            tailX = currentPosition[0];
            tailY = currentPosition[1];
        } else {
            findTailRecursive();
        }
        return result = new int[]{tailX, tailY, length};
    }
}
