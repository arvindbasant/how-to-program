package java8recipes.basics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* can be used with
* object::instanceMethod -> System.out::println
* Class::staticMethod -> Math::Max
* Class::instanceMethod -> String::length
* */
public class MethodReferencesDemo {

    public static void main(String[] args) {
        Stream.of(2, 3, 4, 1, 33, 45)
                .forEach(x -> System.out.println(x));

        Stream.of(2, 3, 4, 1, 33, 45)
                .forEach(System.out::println);

        Consumer<Integer> consumer = System.out::println;

        Stream.of(2, 3, 4, 1, 33, 45)
                .forEach(consumer);

        // using mtd ref in static mtd

        Consumer<Double> doubleConsumer = System.out::println;
        Stream.generate(Math::random)
                .limit(10)
                .forEach(doubleConsumer);

        List<String> stringList = Arrays.asList("this", "is", "a", "list", "of", "strings");

        List<String> sorted = stringList.stream()
                .sorted(String::compareTo) // .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());

        Stream.of("this", "is", "a", "stream", "of", "strings")
                .map(String::length)
                .forEach(System.out::println);
    }
}








