package MyStringTest;

/**
 * Created by buxia on 2015/9/5.
 */
public class InternTest {
    public static void main(String[] args) {
        String s1 = "Too";
        String s2 = "many";
        String s3 = "Too many";
        s1 = s1 + " " + s2;
        StringBuffer s4 = new StringBuffer(4);
        s4.append("ddd89977");
        System.out.println(s4);
//        s1 = s1.intern();
//        System.out.println(s1 == s3);
//        s3 = "change";
//        System.out.println(s1);
//        System.out.println(s1 == s3);

    }
}
