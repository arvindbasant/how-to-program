package java8recipes.basics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @FunctionalInterface Function
 *
 * default <V> Function<T,V> andThen(Function<? super R,? extends V> after)
 * R apply(T t)
 * default <V> Function<V,R> compose(Function<? super V,? extends T> before)
 * static <T> Function<T,T> identity()
 * */
public class FuncDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara",
                "Zoë", "Jayne", "Simon", "River", "Shepherd Book");

        List<Integer> nameLengths = names.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                }).collect(Collectors.toList());

        nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.printf("nameLengths = %s%n", nameLengths);
    }
}
/*
* Map.computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
* Comparator.comparing(Function<? super T,? extends U> keyExtractor)
* Comparator.thenComparing(Function<? super T,? extends U> keyExtractor)
* */
