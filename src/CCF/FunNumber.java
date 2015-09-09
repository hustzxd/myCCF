package CCF;

import java.util.Scanner;

/**
 * ÓÐÈ¤µÄÊý
 * Created by buxia on 2015/9/5.
 */
public class FunNumber {
    public static void main(String[] args) {
        Scanner fin = new Scanner(System.in);
        int n = fin.nextInt();
        long[] s = new long[6];
        long[] ss = new long[6];
        long mod = 1000000007;
        s[0] = 1;
        s[1] = 0;
        s[2] = 0;
        s[3] = 0;
        s[4] = 0;
        s[5] = 0;
        for (int i = 1; i < n; i++) {

            ss[0] = 1;
            ss[1] = (s[0] + s[1] * 2) % mod;
            ss[2] = (s[0] + s[2]) % mod;
            ss[3] = (s[1] + s[3] * 2) % mod;
            ss[4] = (s[1] + s[2] + s[4] * 2) % mod;
            ss[5] = (s[3] + s[4] + s[5] * 2) % mod;

            for (int j = 0; j < 6; j++) {
                s[j] = ss[j];
            }
        }

        System.out.println(ss[5]);
    }

}
