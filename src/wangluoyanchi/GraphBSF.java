package wangluoyanchi;


/**
 * ������ȱ���ͼ
 * Created by buxia on 2015/9/7.
 */
public class GraphBSF {
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
