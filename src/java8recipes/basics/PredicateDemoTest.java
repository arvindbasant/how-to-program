package java8recipes.basics;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.Stream;

import static java8recipes.basics.PredicateDemo.*;
import static org.junit.Assert.assertEquals;

public class PredicateDemoTest {
    private final PredicateDemo demo = new PredicateDemo();
    private String[] names;

    @Before
    public void setUp() {
        names = Stream.of("Mal", "Wash", "Kaylee", "Inara", "Zoë",
                "Jayne", "Simon", "River", "Shepherd Book")
                .sorted()
                .toArray(String[]::new);
    }

    @Test
    public void getNamesOfLength5() throws Exception {
        assertEquals("Inara, Jayne, River, Simon",
                demo.getNamesOfLength(5, names));
    }

    @Test
    public void getNamesStartingWithS() throws Exception {
        assertEquals("Shepherd Book, Simon",
                demo.getNamesStartingWith("S", names));
    }

    @Test
    public void getNamesSatisfyingCondition() throws Exception {
        assertEquals("Inara, Jayne, River, Simon",
                demo.getNamesSatisfyingCondition(s -> s.length() == 5, names));
        assertEquals("Shepherd Book, Simon",
                demo.getNamesSatisfyingCondition(s -> s.startsWith("S"),
                        names));
        assertEquals("Inara, Jayne, River, Simon",
                demo.getNamesSatisfyingCondition(LENGTH_FIVE, names));
        assertEquals("Shepherd Book, Simon",
                demo.getNamesSatisfyingCondition(STARTS_WITH_S, names));
    }

    @Test
    public void composedPredicate() throws Exception {
        assertEquals("Simon",
                demo.getNamesSatisfyingCondition(
                        LENGTH_FIVE.and(STARTS_WITH_S), names));

        assertEquals("Inara, Jayne, River, Shepherd Book, Simon",
                demo.getNamesSatisfyingCondition(LENGTH_FIVE.or(STARTS_WITH_S), names));

        assertEquals("Kaylee, Mal, Shepherd Book, Wash, Zoë",
                demo.getNamesSatisfyingCondition(LENGTH_FIVE.negate(), names));
    }
}