package java8recipes.basics;

public class Person {
    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public Person(Person person) {
        this.name = person.name;
    }

    public Person(String... names) {
        this.name = String.join(" ", names);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
