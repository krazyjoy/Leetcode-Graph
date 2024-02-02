package Min_Spanning_Tree;

import java.util.Arrays;
import java.util.Comparator;

/*
    Kruskal - Min-spanning-tree
    sort edge by distance cost ascendingly
    every time find the smallest edge, if two vertices connected by this edge are not in the same connected component
    then merge these 2 vertices and accumulate the connection cost.

    terminate when the number of connected component is 1 (all vertices are connected)

 */
public class Connecting_Cities_With_Min_Cost1135 {
    public static void main(String[] args) {
        int[][] connections = new int[][]{
                {1,2,5},
                {1,3,6},
                {2,3,1}
        };
        System.out.println(minimumCost(3, connections));

        int[][] connections2 = new int[][]{
                {1,2,3},
                {3,4,4}
        };
        System.out.println(minimumCost(4, connections2));
    }
    public static int minimumCost(int n, int[][] connections){
        Arrays.sort(connections, Comparator.comparingInt(a->a[2]));

        int[] parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        int ans=0, remain=n;
        for(int[] e: connections){
            int x = e[0], y = e[1], cost = e[2];
            if(find(parent, x) == find(parent, y)){
                continue;
            }
            union(parent, x,y);
            ans += cost;
            remain-=1;

        }

        return remain==1?ans:-1;
    }
    private static int find(int[] p, int x){
        if(p[x] != x){
            p[x] = find(p, p[x]);
        }
        return p[x];
    }
    private static void union(int[] p, int u, int v){
        int uu = find(p, u);
        int vv = find(p, v);
        if(uu!=vv){
            p[uu] = vv;
        }
    }
}
