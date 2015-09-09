package CCF;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 集合竞价
 * Created by buxia on 2015/9/4.
 */
public class Jihejingjia {
    class StockArray {
        String flag;
        float price;
        int number;
    }

    public static void main(String[] args) {
        new Jihejingjia().run();
    }

    private void run() {
        Scanner fin = new Scanner(System.in);
        StockArray[] ss = new StockArray[5002];
        for (int i = 0; i < 5002; i++) {
            ss[i] = new StockArray();
        }

        int num = 1;//输入总行数
        while (fin.hasNext()) {
            ss[num].flag = fin.next();
            if (ss[num].flag.equals("buy") || ss[num].flag.equals("sell")) {
                ss[num].price = fin.nextFloat();
                ss[num].number = fin.nextInt();
            } else if (ss[num].flag.equals("cancel")) {
                ss[fin.nextInt()].flag = "cancel";
            }
            num++;
        }
        System.out.println("----Input ---- end!----");
        StockArray[] buyArray = new StockArray[num];//买方
        for (int i = 0; i < num; i++) {
            buyArray[i] = new StockArray();
        }
        StockArray[] sellArray = new StockArray[num];//卖方
        for (int i = 0; i < num; i++) {
            sellArray[i] = new StockArray();
        }
        int sellNum = 0;
        int buyNum = 0;
        for (int i = 0; i < num; i++) {
            if (ss[i].flag.equals("buy")) {//Buy的出价和交易量
                buyArray[buyNum].price = ss[i].price;
                buyArray[buyNum].number = ss[i].number;
                buyNum++;
            }
            if (ss[i].flag.equals("sell")) {//Sell的出价和交易量
                buyArray[sellNum].price = ss[i].price;
                buyArray[sellNum].number = ss[i].number;
                sellNum++;
            }
            Arrays.sort(buyArray,0,buyNum,new BuyComparator());
            Arrays.sort(sellArray,0,sellNum,new SellComparator());


        }
    }
}
class BuyComparator implements Comparator<Object> {
    public int compare(Object o1, Object o2){
        StockArray s1=(StockArray)o1;
        StockArray s2=(StockArray)o2;

        if (s1.price!=s2.price) {
            return s2.price>s1.price ? 1: -1;
        }else {
            return s2.number>s1.number ? 1:-1;
        }
    }
}
class SellComparator implements Comparator<Object> {
    public int compare(Object o1, Object o2){
        StockArray s1=(StockArray)o1;
        StockArray s2=(StockArray)o2;

        if (s1.price!=s2.price) {
            return s2.price>s1.price ? 1: -1;
        }else {
            return s2.number>s1.number ? 1:-1;
        }
    }
}




















