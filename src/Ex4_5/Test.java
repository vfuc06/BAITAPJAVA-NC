package Ex4_5;
public class Test {
    public static void main(String[] args) {
        Shape shape = new Shape("blue", false);
        System.out.println(shape);

        Circle circle = new Circle(2.5, "green", true);
        System.out.println(circle);

        Rectangle rectangle = new Rectangle(2.0, 4.0, "yellow", false);
        System.out.println(rectangle);

        Square square = new Square(3.0, "purple", true);
        System.out.println(square);
    }
}
