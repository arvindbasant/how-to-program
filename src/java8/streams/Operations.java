package java8.streams;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.*;
import static java.util.Arrays.*;

import java.util.stream.Stream;

public class Operations {

    public static void main(String[] args) {

        List<String> collected = Stream.of("a", "b", "c").collect(toList());
        assertEquals(asList("a", "b", "c"), collected);

        List<String> collectedMap = Stream.of("hello", "world")
                .map(String::toUpperCase)
                .collect(toList());
        assertEquals(asList("HELLO", "WORLD"), collectedMap);

        List<String> startsWithDigit = Stream.of("1abc", "2abd", "ghf3")
                .filter(str -> Character.isDigit(str.charAt(0)))
                .collect(toList());

        assertEquals(asList("1abc", "2abd"), startsWithDigit);
    }
}
