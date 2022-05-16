package java8recipes.basics;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @FunctionalInterface Predicate
 *
 * default Predicate<T> and(Predicate<? super T> other)
 * static <T> Predicate<T> isEquals(Object targetRef)
 * default Predicate<T> negate()
 * default Predicate<T> or(Predicate<? super T> other)
 * boolean test(T t)
 * */
public class PredicateDemo {

    // predicates are used usually for filtering the stream

    public String getNamesSatisfyingCondition(Predicate<String> condition, String... names) {
        return Arrays.stream(names)
                .filter(condition)
                .collect(Collectors.joining(", "));
    }

    public static final Predicate<String> LENGTH_FIVE = s -> s.length() == 5;
    public static final Predicate<String> STARTS_WITH_S = s -> s.startsWith("S");

    public String getNamesOfLength(int length, String... names) {
        return Arrays.stream(names)
                .filter(s -> s.length() == length)
                .collect(Collectors.joining(", "));
    }

    public String getNamesStartingWith(String s, String... names){

        return Arrays.stream(names)
                .filter(s1 -> s1.startsWith(s))
                .collect(Collectors.joining(", "));
    }
}
/*
* Other methods in the standard library that use predicates include:
*
* Optional.filter(Predicate<? super T> predicate)
* Collection.removeIf(Predicate<? super E> filter)
* Stream.allMatch(Predicate<? super T> predicate)
* Collectors.partitioningBy(Predicate<? super T> predicate)
*
* */