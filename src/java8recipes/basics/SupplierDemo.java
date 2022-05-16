package java8recipes.basics;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.logging.Logger;

/*
 * @FunctionalInterface
 * T get()
 *
 * Other supplier interfaces:
 *
 * IntSupplier int getAsInt()
 * DoubleSupplier double getAsDouble()
 * LongSupplier long getAsLong()
 * BooleanSupplier boolean getAsBoolean()
 * */
public class SupplierDemo {
    private static final Logger logger = Logger.getLogger("..");

    public static void main(String[] args) {
        DoubleSupplier randomSupplier = Math::random;

        /*
         * 1. Primitives don't have a .toString() as they are not an implementation of the Object-class, so only String.valueOf can be used.
         * 2. String.valueOf will transform a given object that is null to the String "null", whereas .toString() will throw a NullPointerException.
         * */

        logger.info(String.valueOf(randomSupplier.getAsDouble()));

        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara",
                "Zoë", "Jayne", "Simon", "River", "Shepherd Book");

        // Optional is a nonnull object that either wraps a value or
        //is empty
        Optional<String> first = names.stream()
                .filter(name -> name.startsWith("C"))
                .findFirst();

        System.out.println(first); // Optional.empty
        System.out.println(first.orElse("None")); // None

        // Forms the comma-separated str, even when name is found
        System.out.println(first.orElse(String.format("No result found in %s",
                String.join(", ", names))));

        // Forms the comma-separated str only if the Optional is empty
        System.out.println(first.orElseGet(() -> String.format("No result found in %s",
                String.join(", ", names))));

        /*
        * The orElseThrow method in Optional, which takes a Supplier<X extendsException>.
        * The Supplier is only executed if an exception occurs.
        *
        * Objects.requireNonNull(T obj, Supplier<String> messageSupplier) only
        * customizes its response if the first argument is null.
        *
        * CompletableFuture.supplyAsync(Supplier<U> supplier)
        *
        * The Logger class has overloads for all its logging methods that takes a
        * Supplier<String> rather than just a string
        * */
    }
}
