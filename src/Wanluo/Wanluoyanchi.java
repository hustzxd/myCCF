package Wanluo;

import java.util.Scanner;

public class Wanluoyanchi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner fin = new Scanner(System.in);
		int n = fin.nextInt();// ��������̨��
		int m = fin.nextInt();// �ն˵�̨��
		Edge[] edges = new Edge[m + n];
		for (int i = 1; i < edges.length; i++) {
			edges[i] = new Edge(i + 1, fin.nextInt());
		}
		Graph G = new Graph(n + m + 1);// 0��㲻�ÿ���
		for (int i = 1; i < edges.length; i++) {
			G.insert(edges[i]);
		}
		GraphBSF graphBSF = new GraphBSF(G, 1);
		int[][] order = graphBSF.getOrdBSF();
		GraphBSF graphBSF1 = new GraphBSF(G, order[m + n][0]);

		int[][] order2 = graphBSF1.getOrdBSF();
		System.out.println(order2[m + n][1]);

	}

}
/**
 * Created by buxia on 2015/9/7.
 */
 class Edge {
    public int v, w;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

 /**
  * ������ȱ���ͼ
  * Created by buxia on 2015/9/7.
  */
class GraphBSF {
     private Graph G;
     private int v;
     private int[][] q;    //q[i][0]������
     // q[i][1]�����i����㵽�����Ĳ���
     private boolean[] visited;

     public GraphBSF(Graph G, int v) {
         //��v��㿪ʼ���б���
         q = new int[G.V() + 1][2];
         visited = new boolean[G.V() + 1];
         for (int i = 1; i < G.V() + 1; i++) {
             visited[i] = false;
         }
         this.G = G;
         this.v = v;
         q[1][0] = this.v;
         q[1][1] = 0;
         visited[v] = true;//i����Ƿ񱻷��ʹ�
         int qEnd = 1;
         for (int i = 1; i < G.V(); i++) {//iָ������� pEndָ�����β

             AdjList A = G.getAdjList(q[i][0]);
             for (int t = A.begin(); !A.end(); t = A.next()) {
                 if (!visited[t]) {
                     visited[t] = true;
                     qEnd++;
                     q[qEnd][0] = t;
                     q[qEnd][1] = q[i][1] + 1;
                 }
             }
             if (qEnd == G.V()) break;
         }
     }

     public int[][] getOrdBSF() {
         return q;
     }
 }

/**
 * �����ݴ浽ͼ��
 * Created by buxia on 2015/9/7.
 */
class Graph  {

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

/**
 * Created by buxia on 2015/9/7.
 */
interface AdjList {
    int begin();

    int next();

    boolean end();
}


