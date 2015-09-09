package CCF;

import java.util.Scanner;

/**
 * ISBN号码
 * Created by buxia on 2015/9/5.
 */
public class ISBN {
    public static void main(String[] args) {
        Scanner fin = new Scanner(System.in);
        String ISBN_0 = fin.nextLine();
        int len = ISBN_0.length();//13
        int result = 0;
        int k = 1;//每位数字乘以数的权重
        char[] chars = ISBN_0.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            if (chars[i] != '-') {
                result += (chars[i] - '0') * k;
                k++;
            }
        }

        char ISBN_result = 'X';
        result = result % 11;
        if (result != 10) {
            ISBN_result = (char) (result + '0');
        }
        if (ISBN_result == chars[len - 1]) {
            System.out.println("Right");
        } else {
            String ISBN_right = ISBN_0.substring(0, len - 1);
            System.out.println(ISBN_right + ISBN_result);
        }
    }
}
