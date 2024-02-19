package floyd_warshell;

import java.util.Arrays;

public class Design_Graph_With_Shortest_Path_2642 {
    public int[][] matrix;
    public Design_Graph_With_Shortest_Path_2642(int n, int[][] edges) {
        matrix = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
            matrix[i][i] = 0;
        }
        for(int[] edge: edges){
            int from = edge[0], to = edge[1], cost = edge[2];
            matrix[from][to] = cost;

        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE){
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }


    }

    public void addEdge(int[] edge) {
        matrix[edge[0]][edge[1]] = edge[2];
        int n = matrix.length;
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE){
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }


    }

    public int shortestPath(int node1, int node2) {
        return matrix[node1][node2] == Integer.MAX_VALUE?-1:matrix[node1][node2];
    }
}
