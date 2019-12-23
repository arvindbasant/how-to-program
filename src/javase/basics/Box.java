package javase.basics;

public class Box {
    double height;
    double width;
    double depth;

    Box() {
        height = 1;
        width = 1;
        depth = 1;
    }

    @Override
    public String toString() {
        return "hello";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    Box(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    double volume() {
        return height * width * depth;
    }
}
