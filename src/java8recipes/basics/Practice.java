package java8recipes.basics;

public class Practice {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(
                        "inside runnable using an anonymous inner class");
            }
        }).start();

        new Thread(() -> System.out.println("inside runnable using lambda expression"));
    }
}


/*
* Functional programming
* 1. functions should be pure -> for same input output should be always same
* 2. functions should have no shared state
* 3. pass function as argument and can return func(lambda expression in javascript arrow functions)
* */