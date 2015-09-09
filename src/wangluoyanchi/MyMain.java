package wangluoyanchi;

import java.util.Scanner;

/**
 * 将数据存到中，并进行遍历等操作。。。
 * Created by buxia on 2015/9/7.
 */
public class MyMain {
    public static void main(String[] args) {
        Scanner fin = new Scanner(System.in);
        int n = fin.nextInt();//交换机的台数
        int m = fin.nextInt();//终端的台数
        Edge[] edges = new Edge[m + n];
        for (int i = 1; i < edges.length; i++) {
            edges[i] = new Edge(i + 1, fin.nextInt());
        }

//        System.out.println("=====================");
//        for (int i = 1; i < edges.length; i++) {
//            System.out.println(edges[i].v + " " + edges[i].w);
//        }


        Graph G = new Graph(n + m + 1);//0结点不用考虑
        for (int i = 1; i < edges.length; i++) {
            G.insert(edges[i]);
        }

//        for (int i = 0; i < G.V(); i++) {
//            System.out.print(i + ": ");
//            AdjList A = G.getAdjList(i);
//            for (int j = A.begin(); !A.end(); j = A.next()) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }
        GraphBSF graphBSF = new GraphBSF(G, 1);
        int[][] order = graphBSF.getOrdBSF();
//        for (int i = 1; i <= m + n; i++) {
//            System.out.print(order[i][0]+" ");
//        }
//        System.out.println();
//        for (int i = 1; i <= m + n; i++) {
//            System.out.print(order[i][1]+" ");
//        }
//        System.out.println("=========================");

        GraphBSF graphBSF1 = new GraphBSF(G,order[m+n][0]);

        int[][] order2 = graphBSF1.getOrdBSF();
//        for (int i = 1; i <= m + n; i++) {
//            System.out.print(order2[i][0]+" ");
//        }
//        System.out.println();
//        for (int i = 1; i <= m + n; i++) {
//            System.out.print(order2[i][1]+" ");
//        }
//        System.out.println();
        System.out.println(order2[m+n][1]);
    }
}
