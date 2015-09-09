package CCF;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class StockArray{           
    String SBC;
    float price;
    int number;
}

public class stocks {

    public static void main(String[] args){

        System.out.println("please input data");

        Scanner scanner=new Scanner(System.in);

        StockArray[] ss=new StockArray[5002];
        for (int i = 0; i < 5002; i++) {
            ss[i]=new StockArray();
        }


        int num=1;
        while(scanner.hasNext()){
            ss[num].SBC=scanner.next();
            if (ss[num].SBC.equals("buy")||ss[num].SBC.equals("sell")) {
                ss[num].price=scanner.nextFloat();
                ss[num].number=scanner.nextInt();
            }else if (ss[num].SBC.equals("cancel")) {
                ss[scanner.nextInt()].SBC="CANCEL"; //如果取消，则将相应行标记为CANCEL
            }

            num++;
        }
        System.out.println("aabua");

        StockArray[] n1=new StockArray[num]; //买方
        for (int i = 0; i < num; i++) {
            n1[i]=new StockArray();
        }

        StockArray[] n2=new StockArray[num];  //卖方
        for (int i = 0; i < num; i++) {
            n2[i]=new StockArray();
        }

        int num1=0;
        int num2=0;
        int ans_num=0;
        float ans_price=0;

        for(int i=1;i<num;i++){
            if (ss[i].SBC.equals("buy")) { //放入Buy的出价和交易量
                n1[num1].price=ss[i].price;
                n1[num1].number=ss[i].number;
                num1++;
            }
            if (ss[i].SBC.equals("sell")) {  //放入sell的出价和交易量
                n2[num2].price=ss[i].price;
                n2[num2].number=ss[i].number;
                num2++;
            }
        }

        Arrays.sort(n1,0,num1,new MyComprator1());
        Arrays.sort(n2,0,num2,new MyComprator2());

        int sum1=0, sum2;
        float p;
        for (int i = 0; i < num1; i++) { //n1买方,n2卖方
            p=n1[i].price;
            sum1+=n1[i].number;
            sum2=0;
            for (int j = 0; j < num2; j++) {
                if (n2[j].price>n1[i].price) 
                    break;
                    sum2+=n2[j].number; 
            }

            int min_sum=Math.min(sum1, sum2);

            if (ans_num<min_sum) {
                ans_num=min_sum;
                ans_price=p;
            }
        }

        System.out.println("the result is ");
        DecimalFormat df = new DecimalFormat(".00");
        if (ans_price==0) {
            System.out.print(0+df.format(ans_price)+" "+ans_num);
        }else {
            System.out.print(df.format(ans_price)+" "+ans_num);
        }

        scanner.close();
    }

}

class MyComprator1 implements Comparator<Object>{
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

class MyComprator2 implements Comparator<Object>{
    public int compare(Object o1, Object o2){
        StockArray s1=(StockArray)o1;
        StockArray s2=(StockArray)o2;
        if (s1.price!=s2.price) {
            return s1.price>s2.price ? 1: -1;
        }else {
            return s1.number>s2.number ? 1:-1;
        }   
    }
}