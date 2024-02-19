package Find_Eventual_Safe_States;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_Eventual_Safe_States_802 {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1,2},
                {2,3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        System.out.println(eventualSafeNodes(graph));

        int[][] graph2 = new int[][]{
                {1,2,3,4},
                {1,2},
                {3,4},
                {0,4},
                {}
        };
        System.out.println(eventualSafeNodes(graph2));
    }
    public static List<Integer> eventualSafeNodes(int[][] graph){
        int n = graph.length;
        int[] safe = new int[n]; // currently safe or not
        Arrays.fill(safe, 0); // uncertain
        boolean[] visited = new boolean[n]; // has been visited in this path or not

        for(int i=0; i<n; i++){
            if(safe[i] == 0){
                visited[i] = true;
                dfs(graph, safe, visited, i);
                visited[i] = false;
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(safe[i] == 1){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    public static boolean dfs(int[][] graph, int[] safe, boolean[] visited, int node){
        // assume node is safe
        boolean isSafe=true;

        for(int neigh: graph[node]){
            // cycle
            if(visited[neigh]){
                isSafe = false;
                break;
            }
            else if(safe[neigh] == 2){ // has been marked unsafe while traveling other paths
                isSafe = false;
                break;
            }

            if(safe[neigh] == 1){ // keep go on the path until reaches terminal node
                continue;
            }
            visited[node] = true;
            if(!dfs(graph, safe, visited, neigh)){ // find the safe status of terminal node
                isSafe = false;
            }
            visited[node] = false;
        }
        safe[node] = isSafe?1:2;
        return isSafe;
    }
}
