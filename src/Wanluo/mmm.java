package Wanluo;

import java.util.Scanner;

/**
 * Created by buxia on 2015/9/8.
 */
public class mmm {
    public static void main(String[] args) {
        new mmm().run();
    }

    public void run() {
        int n;
        Scanner fin = new Scanner(System.in);
        n = fin.nextInt();
        int[] count = new int[n];
        for (int i = 0; i < count.length; i++) {
            count[i] = fin.nextInt();
        }
        MyNumber[] numbers = new MyNumber[n];
        // ��ʼ������
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new MyNumber();
        }
        boolean index = false;// ���������ҵ���ͬ���ֵı�־
        int p = 0;// �������Ѵ���ĩλ���ֵ�λ��
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < p; j++) {
                if (numbers[j].number == count[i]) {
                    index = true;
                    numbers[j].count++;
                }
            }
            if (!index) {
                numbers[p].number = count[i];
                numbers[p].count = 1;
                numbers[p].index = true;
                p++;
            }
            index = false;
        }

        // ����
        int count2 = 0;// ��������Ч����
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].index) {
                count2++;
            }
        }
        for (int i = 0; i < count2; i++) {
            for (int j = 0; j < count2 - 1 - i; j++) {
                if (numbers[j + 1].biggerThan(numbers[j])) {
                    MyNumber temp;
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].index) {
                System.out.println(numbers[i].toString());
            }
        }
    }
}

class MyNumber {
    public int number;
    public int count;
    public boolean index;// �Ƿ�ʹ��

    public MyNumber() {
        number = 0;
        count = 0;
        index = false;
    }

    @Override
    public String toString() {
        return number + " " + count;
    }

    public boolean biggerThan(MyNumber myNumber1) {
        // TODO Auto-generated method stub
        if (this.count > myNumber1.count) {
            return true;
        } else if (this.count < myNumber1.count) {
            return false;
        } else {
            if (this.number < myNumber1.number) {
                return true;
            } else {
                return false;
            }
        }
    }
}

