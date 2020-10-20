package java8recipes;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * One of the primary use cases for Suppliers is to support the concept of deferred execution.
 *
 * The info method in java.util.logging.Logger takes a Supplier, whose get
 * method is only called if the log level means the message will be seen
 *
 * */
public class SuppliersDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("...");
        DoubleSupplier randomSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };
        randomSupplier = () -> Math.random();
        randomSupplier = Math::random;
        logger.info(() -> "hello");
        logger.info(String.valueOf(randomSupplier.getAsDouble()));
    }
}
