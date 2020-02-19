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

    public int neighbours(int row, int col) {
        return 1;
    }

    public int[] findTailExhaustive() {
        exhaustiveChecks = 0;
        int length = 0;
        for (int i = 0; i < game.length; i++) { //game.length-1 so that right neighbour won't be out of bounds
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j] == true) {
                    length++;
                    exhaustiveChecks ++;
                    int sumNeighbours = neighbours(i, j); //Calling neighbours method to see if cell is a head/tail or none
                    if (sumNeighbours == 1) {}
                }
            }
        }
    }

}
