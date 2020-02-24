public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame() {
        game = new boolean[1][1];
    }

    public SnakeGame(boolean[][] game, int x, int y) {
        this.game = game;
        this.headPosition = new int[2];
        headPosition[0] = x;
        headPosition[1] = y;
        //to test, do I need to hardcode the board with the snake?
    }//complete exhaustive search by Saturday evening

    public int neighbours(int row, int col) { //Helper method to count the neighbours
        int neighbour = 0;
        for (row = 0; row < game.length-1; row++) {
            for (col = 0; col < game[row].length-1; col++) {
                if (game[row][col+1] == true && game[row+1][col] == true && row <) {
                    neighbour ++;
                }
            }
        }
        if (game[row + 1] == true) {
            return 1;
        }
    }

    public int[] findTailExhaustive() {
        exhaustiveChecks = 0;
        int length = 0;
        int[] result = new int[3];
        int i = 0;
        int j = 0;
        for (i = 0; i < game.length; i++) {
            for (j = 0; j < game[i].length; j++) {
                exhaustiveChecks ++;
                if (game[i][j] == true) {
                    length++;
                    int sumNeighbours = neighbours(i, j); //Calling neighbours method to count number of neighbours and see if cell is a head/tail or none
                    if (sumNeighbours == 1) { // Checking to see if cell is a head/tail
                        if (!game[headPosition[0]][headPosition[1]]) { //If the cell is tail
                            exhaustiveChecks --;
                        }
                    }
                }
            }
        }
        return result = new int[]{i, j, length};
    }

}
