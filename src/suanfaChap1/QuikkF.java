package suanfaChap1;

import java.util.Scanner;

/**
 * �����ͨ������Ŀ��ٲ����㷨
 * Created by buxia on 2015/9/4.
 */
public class QuikkF {
    public static void main(String[] args) {
        int pre = (int) System.currentTimeMillis();
        Scanner fin = new Scanner(System.in);
        int N = fin.nextInt();//N�����
        int M = fin.nextInt();//M������
        int id[] = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int p = fin.nextInt();
            int q = fin.nextInt();
            int t = id[p];
            if (t == id[q]) continue;
            for (int j = 0; j < N; j++) {
                if (id[j] == t) id[j] = id[q];
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(id[i] + " ");
        }
        int post = (int) System.currentTimeMillis();
        System.out.println(post-pre);
    }
}
