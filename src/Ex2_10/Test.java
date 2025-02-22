package Ex2_10;
public class Test {
        public static void main(String[] args) {
            MyPoint topLeft = new MyPoint(0, 5);
            MyPoint bottomRight = new MyPoint(5, 0);
            MyRectangle rectangle = new MyRectangle(topLeft, bottomRight);
            System.out.println(rectangle);
            System.out.println("Width: " + rectangle.getWidth());
            System.out.println("Height: " + rectangle.getHeight());
            System.out.println("Area: " + rectangle.getArea());
            System.out.println("Perimeter: " + rectangle.getPerimeter());
            MyRectangle rectangle2 = new MyRectangle(1, 3, 6, 0);
            System.out.println(rectangle2);
            System.out.println("Area of rectangle2: " + rectangle2.getArea());
        }

}
