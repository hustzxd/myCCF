package wangluoyanchi;

/**
 * Created by buxia on 2015/9/7.
 */
public interface IGraph {
    public int E();

    public int V();

    public void insert(Edge edge);

    public void remove(Edge edge);

    public boolean edge(int v, int w);

    public AdjList getAdjList(int v);
}
