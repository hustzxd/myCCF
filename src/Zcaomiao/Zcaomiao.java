package Zcaomiao;

import java.util.Scanner;

/**
 * Created by buxia on 2015/9/3.
 */
public class Zcaomiao {
    public static void main(String[] args) {
        new Zcaomiao().run();
    }

    private void run() {
        Scanner fin = new Scanner(System.in);
        int n = fin.nextInt();
        int[][] numbers = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                numbers[i][j] = fin.nextInt();
            }
        }
        int row = 0;
        int col = 0;
        while (!(row == n - 1 && col == n - 1) ){
            System.out.print(numbers[row][col]+" ");
            if ((row + col) % 2 == 0) {
                if (col == n - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            }else{
                if (row == n-1){
                    col++;
                }else if (col == 0){
                    row ++;
                }else{
                    col--;
                    row++;
                }
            }
        }
        System.out.println(numbers[n-1][n-1]);
    }
}
