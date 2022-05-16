package java8recipes.basics;

/**
 * @FunctionalInterface in java
 * must have SAM(single abstract method)
 * can have default methods
 * can have static methods
 *
 * default methods of Collection interface:
 * default boolean removeIf(Predicate<? super E> filter)
 * default Stream<E> stream()
 * default Stream<E> parallelStream()
 * default Spliterator<E> spliterator()
 *
 * prior to java 8, many utility classes were created that contains only static methods
 * ex: java.util.Collections
 *
 * but in java 8 now we can add static methods to interfaces. The requirements are:
 * add static keyword
 * provide an implementation, in this way they are like default methods and included in default tabs in java docs.
 * Access the method using Interface name. Classes do not need to impl interface to use its static methods.
 * */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FuncInterface {

    public static void main(String[] args) {

        // using default methods
        List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5, 9);
        boolean removed = nums.removeIf(n -> n > 5);
        nums.forEach(System.out::println); // forEach -> default method from Iterable interface


        // using static methods
        List<String> bonds = Arrays.asList("Connery", "Lazenby", "Moore",
                "Dalton", "Brosnan", "Craig");

        List<String> sorted = bonds.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        sorted = bonds.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        sorted = bonds.stream()
                .sorted(Comparator.comparing(String::toLowerCase))
                .collect(Collectors.toList());

        sorted = bonds.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        sorted = bonds.stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }
}











