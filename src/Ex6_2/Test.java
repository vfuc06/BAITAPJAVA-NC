package Ex6_2;

public class Test {
    public static void main(String[] args) {
        GeometricObject circle = new Circle(5.0);
        System.out.println(circle.toString());
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());
        GeometricObject rectangle = new Rectangle(4.0, 7.0);
        System.out.println(rectangle.toString());
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());
    }
}
