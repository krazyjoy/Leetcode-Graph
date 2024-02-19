package connected_components_isConnected;
import connected_components_isConnected.UnionFind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class number_of_provinces {
    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1,1,0}, {1,1,0},{0,0,1}};
        System.out.println(number_of_provinces(isConnected));

        System.out.println(findProvinces(isConnected));
        isConnected = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findProvinces(isConnected));
    }
    /*
        dfs:
        use seen[] boolean array to specify visited nodes
        when a new dfs starts from outer loop of isConnected, and meets new unseen node,
        number of provinces increased by 1


     */
    public static int number_of_provinces(int[][] isConnected){
        int n = isConnected.length;
        int n_provinces = 0;
        boolean[] seen = new boolean[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1){
                    if(!seen[i]){
                        n_provinces += 1;
                        seen[i] = true;
                        dfs(i, isConnected, seen);
                    }
                }
            }
        }
        return n_provinces;
    }
    public static void dfs(int node, int[][] isConnected, boolean[] seen){
        for(int j=0; j<isConnected[node].length; j++){
            if(isConnected[node][j] == 1 && !seen[j]){
                seen[j] = true;
                dfs(j, isConnected, seen);
            }
        }
    }
    /*
        union-find approach

     */

    public static int findProvinces(int[][] isConnected){
        // use isConnected to build unions that are connected



        int n_provinces = 0;
        int n = isConnected.length;
        UnionFind union_find = new UnionFind(n);


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1){
                    union_find.union(
                            i+1, j+1
                    );
                }
            }
        }

        System.out.println(Arrays.toString(union_find.parent));
        Set<Integer> set = new HashSet<>();
        for(int root: union_find.parent){
            set.add(root);
        }
        return set.size()-1; // skip city == 0
    }
}
