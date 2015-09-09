package suanfaChap1;

/**
 * Created by buxia on 2015/9/4.
 */
public class Testgcd {
    static int gcd(int M, int N) {
        if (N == 0) return M;
        return gcd(N, M % N);
    }

    public static void main(String[] args) {
        System.out.println(gcd(314159,271829));
    }
}
