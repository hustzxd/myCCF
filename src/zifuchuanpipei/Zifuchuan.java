package zifuchuanpipei;

import java.util.Scanner;

/**
 *
 * Created by buxia on 2015/9/8.
 */
public class Zifuchuan {
    public static void main(String[] args) {
        Scanner fin = new Scanner(System.in);
        String s = fin.nextLine();
        int flag = fin.nextInt();
        int n = fin.nextInt();
        String[] ss = new String[n];
        fin.nextLine();
        for (int i = 0; i < n; i++) {
            ss[i]= fin.nextLine();
        }
        for (int i = 0; i < n; i++)
            if (flag == 1) {//
                //
                if (ss[i].contains(s)) System.out.println(ss[i]);
            } else {
                String t = ss[i].toLowerCase();
                if (t.contains(s.toLowerCase())) {//found
                    System.out.println(ss[i]);
                }
            }
    }
}
