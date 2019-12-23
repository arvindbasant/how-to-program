package java8.lambdas;

import java.util.*;

public class ComparatorLambda {

    public static void main(String[] args) {
        Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        List<String> list = Arrays.asList("****", "***", "**", "*");
        list.sort(comparator);
        for(String s : list)
            System.out.println(s);

    }
}
