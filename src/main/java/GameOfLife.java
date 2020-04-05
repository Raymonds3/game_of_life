public class GameOfLife {
    static void nextGeneration(int grid[][], int X, int Y)
    {
        int[][] nextGen = new int[X][Y];
        for (int l = 1; l < X - 1; l++) {
            for (int m = 1; m < Y - 1; m++) {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];
                    aliveNeighbours -= grid[l][m];
                    if ((grid[l][m] == 1) && (aliveNeighbours < 2)) {
                        nextGen[l][m] = 0;
                    } else if ((grid[l][m] == 1) && (aliveNeighbours == 3 || aliveNeighbours == 2)) {
                        nextGen[l][m] = 1;
                    } else if ((grid[l][m] == 1) && (aliveNeighbours > 3)) {
                        nextGen[l][m] = 0;
                    } else if ((grid[l][m] == 0) && (aliveNeighbours == 3)) {
                        nextGen[l][m] = 1;
                    } else {
                        nextGen[l][m] = grid[l][m];
                    }

            }
        }
        System.out.println("Output Next Generation");
        for (int i = 0; i < X; i++) {
            System.out.print("/");
            for (int j = 0; j < Y; j++) {
                if (nextGen[i][j] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int X = 10, Y = 10;
        int[][] grid = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        System.out.println("Input Current Generation");
        for (int i = 0; i < X; i++) {
            System.out.print("/");
            for (int j = 0; j < Y; j++) {
                if (grid[i][j] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(grid, X, Y);
    }
}
