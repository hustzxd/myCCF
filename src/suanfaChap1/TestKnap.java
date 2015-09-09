package suanfaChap1;

import java.util.Scanner;

/**
 * ±≥∞¸Œ Ã‚
 * Created by buxia on 2015/9/4.
 */
public class TestKnap {
    static class Item {
        public int size;
        public int val;
        Item(int s,int v){
            size = s;
            val = v;
        }
    }

    static int N;
    static Item[] items;

    private static int knap(int cap) {
        int i, space, max, t;
        for (i = 0, max = 0; i < N; i++) {
            if ((space = cap - items[i].size) >= 0) {
                if ((t = knap(space) + items[i].val) > max) {
                    max = t;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner fin = new Scanner(System.in);
        N = fin.nextInt();
        int cap = fin.nextInt();
        items = new Item[N];
        for (int i = 0; i < N; i++) {
            items[i] = new Item(fin.nextInt(),fin.nextInt());
        }
        System.out.println(knap(cap));
    }

}
