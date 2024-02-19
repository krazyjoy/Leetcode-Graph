package connected_components_isConnected;

public class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(int n){
        // index of city starts from 1
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int u){
        if(parent[u] == u){
            return u;
        }
        return parent[u] = find(parent[u]);
    }

    public void union(int u, int v){
        int uu = find(u);
        int vv = find(v);

        if(uu != vv){
            if(rank[uu] < rank[vv]){
                int tmp = vv;
                vv = uu;
                uu = tmp;
            }
            parent[vv] = uu;
            rank[uu] += rank[vv];
        }
    }


}
