package CCF;

import java.util.Scanner;

/**
 * eclipse 上可以按ctrl+z退出输入
 * Created by buxia on 2015/9/4.
 */
public class Input {
    public static void main(String[] args) {
        Scanner fin = new Scanner(System.in);
        while (fin.hasNext()){
            String line = fin.nextLine();
            if (line == null)break;
            System.out.println(line);
        }
        System.out.println("end");
    }
}
