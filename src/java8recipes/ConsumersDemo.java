package java8recipes;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * demo for java.util.function.Consumer
 * void accept(T t)
 * default Consumer<T> andThen(Consumer<? super T> after)
 *
 * other uses:
 * Optional.ifPresent(Consumer<? super T> consumer)
 * Stream.forEach(Consumer<? super T> action)
 * Stream.peek(Consumer<? super T> action)
 */
public class ConsumersDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        strings.forEach(str -> System.out.println(str));
        strings.forEach(System.out::println);

    }
}
