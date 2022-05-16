package java8recipes.streams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java 8 provides several static methods for creating the stream
 * Stream.of, Stream.iterate, and Stream.generate
 *
 * @SafeVarargs
 * public static<T> Stream<T> of(T... values) {
 *      return Arrays.stream(values);
 * }
 *
 * static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
 * returns an infinite (emphasis added) sequential
 * ordered Stream produced by iterative application of a function f to an initial element
 * seed.
 *
 * static <T> Stream<T> generate(Supplier<T> s)
 * This method produces a sequential, unordered stream by repeatedly invoking the
 * Supplier.
 *
 * Collection.stream()
 *
 * There are three child interfaces of Stream specifically for working with primitives:
 * IntStream, LongStream, and DoubleStream.
 *
 * Using range and rangeClosed:
 *     —IntStream.range(int startInclusive, int endExclusive)
 *     —IntStream.rangeClosed(int startInclusive, int endInclusive)
 *     —LongStream.range(long startInclusive, long endExclusive)
 *     —LongStream.rangeClosed(long startInclusive, long endInclusive)
 *
 *
 * Boxed Stream -> process of converting streams of primitives to wrapper instances
 * convert the IntStream to a Stream<Integer>
 * */
public class StreamsDemo {

    public static void main(String[] args) {
        // Stream.of
        String names = Stream.of("Gomez", "Morticia", "Wednesday", "Pugsley")
                .collect(Collectors.joining(","));

        String[] munsters = { "Herman", "Lily", "Eddie", "Marilyn", "Grandpa" };
        names = Arrays.stream(munsters)
                .collect(Collectors.joining(","));

        // Stream.iterate
        List<BigDecimal> nums = Stream.iterate(
                BigDecimal.ONE, n -> n.add(BigDecimal.TEN))
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(nums);

        Stream.iterate(LocalDate.now(), localDate -> localDate.plusDays(1L))
                .limit(5)
                .forEach(System.out::println);
        // Stream.generate
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        // The only quirk in that example is the use of the boxed method to convert the int
        //values to Integer instances
        List<Integer> ints = IntStream.range(10, 15)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints);

        ints = IntStream.of(3, 2, 3, 5, 3)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> n = IntStream.of(3, 2, 3, 5, 3)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
    }
}

