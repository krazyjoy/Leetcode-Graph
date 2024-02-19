package Redundant_Connection;

public class union_find {
    int[] parent;
    int[] rank;
    public union_find(int n){
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i=0; i<n; i++){
            this.parent[i] = i;
            this.rank[i] = 0;
        }
    }
    public int find(int u){
        if(this.parent[u] != u){
            this.parent[u] = find(this.parent[u]);
        }
        return this.parent[u];
    }
    public void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu != pv){
            if(this.rank[pv] > this.rank[pu]){
                int tmp = pu;
                pu = pv;
                pv = tmp;
            }
            this.parent[pv] = pu;
            this.rank[pu] += this.rank[pv];
        }

    }

}
