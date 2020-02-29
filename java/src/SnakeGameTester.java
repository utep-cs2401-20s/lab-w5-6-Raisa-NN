import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeGameTester {
    @Test
    public void findTailExhaustive1() { //Tests if correct array (length (9), x-position of tail(3) and y-position of tail(1)) are returned
        int[] results = {3, 1, 9};
        boolean[][] game = {{false, true, true, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true}};
        SnakeGame sol = new SnakeGame(game, 3, 3);
        assertArrayEquals(results, sol.findTailExhaustive());
    }

    @Test
    public void findTailExhaustive2() { //Tests if correct exhaustiveChecks is returned
        boolean[][] game = {{false, true, true, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true}};
        SnakeGame sol = new SnakeGame(game, 3, 3);
        sol.findTailExhaustive();
        assertEquals(20, SnakeGame.getExhaustiveChecks());
    }

    @Test
    public void findTailExhaustive3() { //Tests helper method findLength() to check if correct length (9) is returned
        boolean[][] game = {{false, true, true, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true}};
        SnakeGame sol = new SnakeGame(game, 3, 3);
        assertEquals(7, sol.findLength());
    }

    @Test
    public void findTailExhaustive4() { //Tests helper method neighbours() to check if correct neighbours is returned
        boolean[][] game = {{false, true, true, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true}};
        SnakeGame sol = new SnakeGame(game, 3, 3);
        assertEquals(1, sol.neighbours(3, 1)); //Finds if neighbours of tail position is really 1
    }

    @Test
    public void findTailExhaustive5() { //Tests if code still works with a different game board
        int[] results = {2, 2, 6};
        boolean[][] game = {{true, true, true, false},
                {true, false, true, false},
                {false, true, false, true},
                {false, false, true, false},
                {false, false, false, false}};
        SnakeGame sol = new SnakeGame(game, 1, 0);
        assertArrayEquals(results, sol.findTailExhaustive());
    }

    @Test
    public void findTailRecursive1() { //Tests if correct length (9), x-position of tail(3) and y-position of tail(1) are returned
        int[] results = {3, 1, 9};
        boolean[][] game = {{false, true, true, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true}};
        SnakeGame sol = new SnakeGame(game, 3, 3);
        assertArrayEquals(results, sol.findTailRecursive());
    }

    @Test
    public void findTailRecursive2() { //Tests if correct recursiveChecks is returned
        boolean[][] game = {{false, true, true, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true}};
        SnakeGame sol = new SnakeGame(game, 3, 3);
        sol.findTailRecursive();
        assertEquals(20, SnakeGame.getRecursiveChecks());
    }

    @Test
    public void findTailRecursive3() { //Tests helper method findLength() to check if correct length (9) is returned
        boolean[][] game = {{false, true, true, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true}};
        SnakeGame sol = new SnakeGame(game, 3, 3);
        assertEquals(9, sol.findLength());
    }

    @Test
    public void findTailRecursive4() { //Tests helper method neighbours() to check if correct neighbours is returned
        boolean[][] game = {{false, true, true, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true},
                {false, true, false, true}};
        SnakeGame sol = new SnakeGame(game, 3, 3);
        assertEquals(1, sol.neighbours(3, 1)); //Finds if neighbours of tail position is really 1
    }

    @Test
    public void findTailRecursive5() { //Tests if code still works with a different game board
        int[] results = {2, 2, 6};
        boolean[][] game = {{true, true, true, false},
                {true, false, true, false},
                {false, true, false, true},
                {false, false, true, false},
                {false, false, false, false}};
        SnakeGame sol = new SnakeGame(game, 1, 0);
        assertArrayEquals(results, sol.findTailRecursive());
    }
}
