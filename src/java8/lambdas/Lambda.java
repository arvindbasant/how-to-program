package java8.lambdas;

import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Lambda {

    public final static ThreadLocal threadSafeFormatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));

    public static void main(String[] args) {
        final String name = "Hello Button";
        Button button = new Button("Hello");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked" + name);
            }
        });

        String effectivelyFinalName = "Hello Button";
        button.addActionListener(event -> System.out.println("button clicked" + effectivelyFinalName));

        Runnable noArgument = () -> System.out.println("running");
        ActionListener oneArgument = event -> System.out.println("button clicked");
        Runnable multiStatement = () -> {
            System.out.println("Hello");
            System.out.println("World");
        };

        BinaryOperator<Long> add = (x, y) -> x + y;
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;

        Predicate<Integer> nonZero = x -> x != 0;

        ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 1);

//        IntPred intPred = x -> x > 5;

//        CheckInt checkInt = x -> x > 5;

    }
}

//interface IntPred {
//    boolean test(Integer value);
//}
//
//interface CheckInt {
//    boolean check(Predicate<Integer> predicate);
//    boolean check(IntPred predicate);
//}