package java8recipes.basics;

import java.util.function.Consumer;
import java.util.stream.Stream;

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
    }
}
