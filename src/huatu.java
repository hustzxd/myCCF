import java.awt.*;
import java.util.Scanner;

/**
 * 画图
 * Created by buxia on 2015/9/8.
 */
public class huatu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//有矩形的个数

        Rectangle[] rectangles = new Rectangle[N];
        int area = 0;
        for (int i = 0; i < N; i++) {
            rectangles[i] = new Rectangle(new Point(scanner.nextInt(), scanner.nextInt()),
                    new Point(scanner.nextInt(), scanner.nextInt()));
            area += rectangles[i].getArea();
        }
        int chong = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                chong += rectangles[i].getChong(rectangles[j]);
            }
        }
        area -= chong;
        System.out.println(area);
    }
}

class Rectangle {

    private Point A, B;

    public Point getA() {
        return A;
    }

    public Point getB() {
        return B;
    }

    public void setA(Point a) {
        A = a;
    }

    public void setB(Point b) {
        B = b;
    }

    public Rectangle() {

    }

    public Rectangle(Point a, Point b) {
        A = a;
        B = b;
    }


    public int getArea() {
        return (int) (Math.abs(A.getX() - B.getX()) * Math.abs(B.getY() - A.getY()));
    }

    public int getChong(Rectangle rec2) {
        Rectangle rec = new Rectangle();
        int x1 = Math.max(this.A.x, rec2.getA().x);
        int y1 = Math.max(this.A.y, rec2.getA().y);
        int x2 = Math.min(this.B.x, rec2.getB().x);
        int y2 = Math.min(this.B.y, rec2.getB().y);
        rec.setA(new Point(x1, y1));
        rec.setB(new Point(x2, y2));
        if (rec.getB().y > rec.getA().y && rec.getB().x > rec.getA().x) {
            return rec.getArea();
        } else {
            return 0;//没有重叠部分
        }
    }
}
