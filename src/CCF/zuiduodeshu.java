package CCF;

import java.util.Scanner;

/**
 * 出现次数最多的数
 * Created by buxia on 2015/9/5.
 */
public class zuiduodeshu {
    public static void main(String[] args) {

        Scanner fin = new Scanner(System.in);
        int n = fin.nextInt();
        int[][] numbers = new int[2][n];
        for (int i = 0; i < n; i++) {
            numbers[0][i] = fin.nextInt();
            numbers[1][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int value = numbers[0][i];
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[0][j] == value) {
                    numbers[1][i] = numbers[1][i] + numbers[1][j];
                    break;
                }
            }
        }
        //寻找出现次数最多的数
        int[] result = new int[2];
        result[0] = numbers[0][0];
        result[1] = numbers[1][0];
        for (int i = 0; i < n; i++) {
            if (numbers[1][i] > result[1]) {
                result[0] = numbers[0][i];
                result[1] = numbers[1][i];
            } else if (numbers[1][i] == result[1] && numbers[0][i] < result[0]) {
                result[0] = numbers[0][i];
                result[1] = numbers[1][i];
            }
        }
        System.out.println(result[0]);
    }

}
