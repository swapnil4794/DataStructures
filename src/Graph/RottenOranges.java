package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String args[]) {
        int[][] grid = new int[][]{{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        RottenOranges rottenOranges = new RottenOranges();
        System.out.println(rottenOranges.orangesRotting(grid));
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }


    public int orangesRotting(int[][] grid) {
        int[][] dist = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int count = 0;
        int rotten = 0;
        int fresh = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        while (!q.isEmpty()) {

            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                for (int[] d : dist) {
                    int x = curr.x + d[0];
                    int y = curr.y + d[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    grid[x][y] = 2;
                    fresh--;
                    q.add(new Pair(x, y));
                }
            }

        }
        return fresh==0?count-1:-1;
    }
}