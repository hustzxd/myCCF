package Graph;

/**
 * Created by buxia on 2015/9/7.
 */
public class GraphDFS {
    private Graph G;
    private int cnt;
    private int[] ord, st;

    private void searchC(Edge e) {
        int w = e.w;
        ord[w] = cnt++;
        st[e.w] = e.v;
        AdjList A = G.getAdjList(w);
        for (int t = A.begin(); !A.end(); t = A.next()) {
            if (ord[t] == -1) searchC(new Edge(w, t));
        }
    }

    GraphDFS(Graph G, int v) {
        this.G = G;
        cnt = 0;
        ord = new int[G.V()];
        st = new int[G.V()];
        for (int t = 0; t < G.V(); t++) {
            ord[t] = -1;
            st[t] = -1;
        }
        for (int t = 0; t < G.V(); t++) {
            if (ord[t] == -1)
                searchC(new Edge(t, t));
        }
    }

    int order(int v) {
        return ord[v];
    }

    int ST(int v) {
        return st[v];
    }
}
