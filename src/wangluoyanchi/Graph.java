package wangluoyanchi;

/**
 * 将数据存到图中
 * Created by buxia on 2015/9/7.
 */
public class Graph implements IGraph {

    private int Vcnt, Ecnt;
    private boolean adj[][];

    public int E() {
        return Ecnt;
    }

    public int V() {
        return Vcnt;
    }

    public boolean edge(int v, int w) {
        return adj[v][w];
    }

    public Graph(int v) {
        this.Vcnt = v;
        Ecnt = 0;
        adj = new boolean[v][v];
    }

    public void insert(Edge e) {
        if (adj[e.v][e.w] == false) Ecnt++;
        adj[e.v][e.w] = true;
        adj[e.w][e.v] = true;
    }

    @Override
    public void remove(Edge e) {
        if (adj[e.v][e.w] == true) Ecnt--;
        adj[e.v][e.w] = false;
        adj[e.w][e.v] = false;
    }

    public AdjList getAdjList(int v) {
        return new AdjArray(v);
    }

    private class AdjArray implements AdjList {
        private int i, v;

        AdjArray(int v) {
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
