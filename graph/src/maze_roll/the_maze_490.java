package maze_roll;

import java.util.LinkedList;
import java.util.Queue;

public class the_maze_490 {
    public static void main(String[] args) {

        int[][] maze = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = new int[]{0, 4};
        int[] dest = new int[]{4, 4};
        System.out.println(hasPath(maze, start, dest));

        int[][] maze2 = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int[] start2 = {0, 4};
        int[] dest2 = {3, 2};
        System.out.println(hasPath(maze2, start2, dest2));
    }


    public static boolean hasPath(int[][] maze, int[] start, int[] dest){
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] seen = new boolean[m][n];

        seen[start[0]][start[1]] = true;

        int[][] directions = new int[][]{
                {1,0},{-1,0},{0,1},{0,-1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            for(int[] dir: directions){
                /* reinitialize startX, startY */

                int x = pos[0], y = pos[1];
                int dx = dir[0], dy = dir[1];
                /* since how many movements should be made is unfixed */
                while(x + dx >= 0 && x + dx <m && y+dy>=0 && y+dy <n && maze[x+dx][y+dy] == 0){
                    x += dx;
                    y += dy;
                }
                if(x == dest[0] && y == dest[1]){
                    return true;
                }
                else if(!seen[x][y]){
                    seen[x][y] = true;
                    queue.add(new int[]{x,y});
                }
            }
        }
        return false;
    }

}
