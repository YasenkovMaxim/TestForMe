package TasksTest.three;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle("red", 5.55));
        shapes.add(new Rectangle("green", 5.7, 4.9));
        shapes.add(new Circle("black", 3.4));
        shapes.add(new Rectangle("weight", 1.7, 6.9));
        System.out.println("\nДо сортировки:");
        for (Shape shape : shapes) {
            shape.displayInfo();
            System.out.println("-------------------");
        }

        shapes.sort(null);
        System.out.println("\nПосле сортировки по площади:");
        for (Shape shape : shapes) {
            shape.displayInfo();
            System.out.println("-------------------");
        }
    }
}
