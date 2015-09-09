package huTu2;

import java.util.Scanner;

/**
 * »­Í¼¡£¡£ÀûÓÃ×ø±ê
 * Created by buxia on 2015/9/8.
 */
public class huatu {
    public static void main(String[] args) {
        int[][] ps = new int[102][102];
        Scanner fin = new Scanner(System.in);
        int n = fin.nextInt();
        int[] rec = new int[4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                rec[j] = fin.nextInt();
            }
            for (int j = rec[0]; j < rec[2]; j++) {
                for (int k = rec[1]; k < rec[3]; k++) {
                    ps[j][k] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (ps[i][j] == 1) count++;
            }
        }
        System.out.println(count);

    }
}
