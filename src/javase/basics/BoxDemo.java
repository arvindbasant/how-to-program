package javase.basics;

public class BoxDemo {

    public static void main(String[] args) {
//        double volume;
        Box box1 = new Box(10.0, 10, 10); // the new operator dynamically allocates memory for an object.
        Box box2 = new Box();
//        Box box1; // declare reference to object
//        box1 = new Box(); // allocate a Box object
//
//        box1.height = 10;
//        box1.width = 10;
//        box1.depth = 10;

//        volume = box1.height * box1.width * box1.depth;
//        System.out.println("vol : " + volume);

        System.out.println("vol from method" + box2.volume());
    }
}
