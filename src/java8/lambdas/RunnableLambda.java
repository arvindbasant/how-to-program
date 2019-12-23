package java8.lambdas;

public class RunnableLambda {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int  i =0; i< 3; i++)
                    System.out.println(Thread.currentThread().getName());
            }
        };

        Runnable runnableLambda = () -> {
            for(int  i =0; i< 3; i++)
                System.out.println(Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnableLambda);
        thread.start();
        thread.join();
    }
}
