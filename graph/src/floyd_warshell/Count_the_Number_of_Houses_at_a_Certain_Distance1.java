package floyd_warshell;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    every house adjacent are connected
    also x-y is connected

    return
        result[k]: # of distance k-1 pairs

    brainstorm:
    floyd-warshall algorithm: finds the shortest path between all the pairs of vertices

    use a matrix to store the current shortest distance from row to col, where
        matrix[row][col] = min distance from row to col

    find immediate vertex k, check each cell if row-k-col path will produce a shorter distance, if so, update matrix


 */
public class Count_the_Number_of_Houses_at_a_Certain_Distance1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countOfPairs(3, 1, 3)));
        System.out.println(Arrays.toString(countOfPairs(5, 2, 4)));
    }
    public static int[] countOfPairs(int n, int x, int y){
        int[][] graph = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
            if(i<n)
                graph[i][i+1] = 1;
            if(i>1)
                 graph[i][i-1] = 1;
        }
        graph[x][y] = 1;
        graph[y][x] = 1;

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE){
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
        /* use a frequency map to store distance counts */
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                countMap.put(graph[i][j], countMap.getOrDefault(graph[i][j], 0)+1);
            }
        }
        /* result[i] is the number of pairs with distance i-1
         */
        int[] result = new int[n];
        for(int i=1; i<=n; i++){
            result[i-1] = countMap.getOrDefault(i, 0);
        }
        return result;
    }
}
