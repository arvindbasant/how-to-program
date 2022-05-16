package practice;


public class Factorial {

    static int fact(int n) {
        if (n == 1)
            return 1;
        return n * fact(n - 1);
    }

    public static void main(String... args) {
        int fact5 = Factorial.fact(5);
        System.out.println(fact5);
    }
}
