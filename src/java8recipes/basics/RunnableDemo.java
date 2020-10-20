package java8recipes.basics;

public class RunnableDemo {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("inside runnable using an anonymous inner class");
            }
        }).start();

        new Thread(() -> System.out.println("inside thread constructor using lambda")).start();

        Runnable r = () -> System.out.println("lambda expression impl runnable run method");

        new Thread(r).start();
    }
}
