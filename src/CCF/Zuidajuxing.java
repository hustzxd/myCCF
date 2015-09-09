package CCF;

import java.util.Scanner;

/**
 * 最大矩形
 * Created by buxia on 2015/9/5.
 */
public class Zuidajuxing {
    public static void main(String[] args) {
        Scanner fin = new Scanner(System.in);
        int n = fin.nextInt();//矩形的个数
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = fin.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int wid = 1;
            int result;
            for (int j = i - 1; j >= 0; j--) {
                if (h[j] >= h[i])
                    wid++;
                else break;
            }
            for (int j = i + 1; j < n; j++) {
                if (h[j] >= h[i])
                    wid++;
                else break;
            }
            result = wid * h[i];
//            System.out.println(result);
            if (max < result) {
                max = result;
            }
        }
        System.out.println(max);
    }
}
