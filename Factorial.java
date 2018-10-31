import java.util.*;
import java.math.BigInteger;

class Factorial {
    public static void main(String[] args) {
        BigInteger f = new BigInteger("1");
        System.out.println(extraLongFactorials(30, f, 0));
    }
    static BigInteger extraLongFactorials(int n, BigInteger f, int i) {
        if (i == n-1) { return f; }
        else { // i != n-1
            f = f.multiply(BigInteger.valueOf(n-i));
            f = extraLongFactorials(n, f, ++i);
        }
        return f;
    }
}
