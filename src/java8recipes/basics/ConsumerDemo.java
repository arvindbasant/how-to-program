package java8recipes.basics;

import java.util.Arrays;
import java.util.List;

/**
* @Functional interface
* void accept(T t)
* default Consumer<T> andThen(Consumer<? super T> after)
*
* contains SAM accept and andThen default method for composition
*
* Ex: forEach method in Iterable interface
* default void forEach(Consumer<? super T> action)
* Stream.peek(Consumer<? super T> action)
* Optional.ifPresent(Consumer<? super T> consumer)
*
* additional consumer interfaces:
*
* IntConsumer void accept(int x)
* DoubleConsumer void accept(double x)
* LongConsumer void accept(long x)
* BiConsumer void accept(T t, U u)
* */
public class ConsumerDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

        strings.forEach(System.out::println);
    }
}
