package java8.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MethodReferences {

    public static void main(String[] args) {
        Stream.of(1, 2)
                .forEach(num -> System.out.println(num));

        Stream.of(1, 2, 3)
                .forEach(System.out::println);

        Consumer<Integer> printer = System.out::println;
        Stream.of(1, 2, 3, 4)
                .forEach(printer);

        // with static methods
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        Stream.of("Hello", "world")
                .forEach(str -> System.out.println(str.length()));

        Integer sum = Stream
                .of("Hello", "world")
                .mapToInt(String::length)
                .sum();

        List<String> strings =
                Arrays.asList("this", "is", "a", "list", "of", "strings");
    }
}
