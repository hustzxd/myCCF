package xianglinshudui;

import java.util.Scanner;

/**
 * ÏàÁÚÊı¶Ô
 * Created by buxia on 2015/9/8.
 */
public class Mymain {
    public static void main(String[] args) {
        Scanner fin = new Scanner(System.in);
        int N = fin.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = fin.nextInt();
        }
//        System.out.println("=====================");
//        for (int i = 0; i < N; i++) {
//            System.out.print(numbers[i] + " ");
//        }
//        System.out.println();
//        System.out.println("=====================");

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Math.abs(numbers[i] - numbers[j]) == 1)
                    count++;
            }
        }
        System.out.print(count);


    }
}
