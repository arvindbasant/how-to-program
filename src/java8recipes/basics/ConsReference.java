package java8recipes.basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ConsReference {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("arvind"), new Person("anurag"), new Person("pallavi"), new Person("shreya"), new Person("riya"));
        List<String> nameList = people.stream()
                .map(Person::getName) // .map(person -> person.getName())
                .collect(Collectors.toList());

        List<String> names = Arrays.asList("arvind", "anurag");

        List<Person> people1 = names.stream()
                .map(Person::new) // .map(name -> new Person(name))
                .collect(Collectors.toList());

        // copy constructor
        // it is useful if we want to isolate streaming code from the original instances
        Person before = new Person("Jane");
        List<Person> people2 = Stream.of(before)
                .collect(Collectors.toList());


        Person after = people2.get(0);

        assertSame(before, after);
        before.setName("Jhon");
        assertSame("Jhon", after.getName());

        // using copy cons
        people2 = Stream.of(before)
                .map(Person::new)
                .collect(Collectors.toList());

        after = people2.get(0);
        assertNotSame(before, after);
        before.setName("Jane");
        assertNotEquals(before, after);

        // varargs constructor
        names.stream()
                .map(name -> name.split(" "))
                .map(Person::new)
                .collect(Collectors.toList());

        Person[] people3 = names.stream()
                .map(Person::new)
                .toArray(Person[]::new); // cons reference for array of Person

    }
}
