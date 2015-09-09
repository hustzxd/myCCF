package Graph;


/**
 * 图的实现，，邻接矩阵
 * Created by buxia on 2015/9/6.
 */
public class Graph {
    private int Vcnt, Ecnt;
    private boolean digraph;
    private boolean adj[][];

    Graph(int V, boolean flag) {
        Vcnt = V;
        Ecnt = 0;
        digraph = flag;
        adj = new boolean[V][V];
    }

    int V() {
        return Vcnt;
    }

    int E() {
        return Ecnt;
    }

    boolean directed() {
        return digraph;
    }

    void insert(Edge e) {
        int v = e.v, w = e.w;
        if (adj[v][w] == false) Ecnt++;
        adj[v][w] = true;
        if (!digraph) adj[w][v] = true;
    }

    void remove(Edge e) {
        int v = e.v, w = e.w;
        if (adj[v][w] == false) Ecnt--;
        adj[v][w] = false;
        if (!digraph) adj[w][v] = false;
    }

    boolean edge(int v, int w) {
        return adj[v][w];
    }

    AdjList getAdjList(int v) {
        return new AdjArray(v);

    }

    private class AdjArray implements AdjList {

        private int i, v;

        public AdjArray(int v) {
            this.v = v;
            i = -1;
        }

        @Override
        public int begin() {
            i = -1;
            return next();
        }

        @Override
        public int next() {
            for (i++; i < V(); i++) {
                if (edge(v, i) == true) return i;
            }
            return -1;
        }

        @Override
        public boolean end() {
            return i >= V();
        }
    }

}









