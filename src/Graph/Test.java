package Graph;

/**
 * Í¼µÄ²âÊÔ
 * Created by buxia on 2015/9/7.
 */
public class Test {
    public static void main(String[] args) {
        Graph graph2 = new Graph(13, false);
        graph2.insert(new Edge(0, 1));
        graph2.insert(new Edge(0, 2));
        graph2.insert(new Edge(0, 6));
        graph2.insert(new Edge(0, 5));
        graph2.insert(new Edge(3, 5));
        graph2.insert(new Edge(3, 4));
        graph2.insert(new Edge(4, 6));
        graph2.insert(new Edge(4, 5));
        graph2.insert(new Edge(7, 8));
        graph2.insert(new Edge(9, 10));
        graph2.insert(new Edge(9, 11));
        graph2.insert(new Edge(9, 12));
        graph2.insert(new Edge(11, 12));


        show(graph2);
        GraphDFS graphDFS = new GraphDFS(graph2, 0);
        for (int i = 0; i < graph2.V(); i++) {
            System.out.print(graphDFS.ST(i) + " ");
        }
        System.out.println();
    }

    private static void show(Graph g) {
        for (int i = 0; i < g.V(); i++) {
            System.out.print(i + ": ");
            AdjList A = g.getAdjList(i);
            for (int j = A.begin(); !A.end(); j = A.next()) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
