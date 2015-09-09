package Graph;

/**
 * 图的存储，，邻接表
 * Created by buxia on 2015/9/7.
 * perfect!!
 */
public class Graph2 {
    private int Vcnt, Ecnt;
    private boolean digraph;

    private class Node {
        int v;
        Node next;

        Node(int x, Node t) {
            v = x;
            next = t;
        }
    }

    private Node adj[];

    Graph2(int V, boolean flag) {
        Vcnt = V;
        Ecnt = 0;
        digraph = flag;
        adj = new Node[V];
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
        adj[v] = new Node(w, adj[v]);
        if (!digraph) adj[w] = new Node(v, adj[w]);
        Ecnt++;
    }

    AdjList getAdjList(int v) {
        return new AdjLinkedList(v);
    }

    private class AdjLinkedList implements AdjList {

        private int v;
        private Node t;//指针。。

        public AdjLinkedList(int v) {
            this.v = v;
            t = null;
        }

        @Override
        public int begin() {
            t = adj[v];
            return t == null ? -1 : t.v;
        }

        @Override
        public int next() {
            if (t != null)
                t = t.next;
            return t == null ? -1 : t.v;
        }

        @Override
        public boolean end() {
            return t == null;
        }
    }
}