package Ex2_6to2_9;
public class TestMyCircle {
    public static void main(String[] args) {
        MyCircle circle1 = new MyCircle();
        System.out.println(circle1);
        MyCircle circle2 = new MyCircle(3, 4, 5);
        System.out.println(circle2);

        MyPoint center = new MyPoint(6, 7);
        MyCircle circle3 = new MyCircle(center, 10);
        System.out.println(circle3);
        System.out.println("Radius of circle1: " + circle1.getRadius());
        circle1.setRadius(7);
        System.out.println("New radius of circle1: " + circle1.getRadius());

        System.out.println("Center of circle2: " + circle2.getCenter());
        circle2.setCenter(new MyPoint(8, 9));
        System.out.println("New center of circle2: " + circle2.getCenter());

        System.out.println("Area of circle3: " + circle3.getArea());
        System.out.println("Circumference of circle3: " + circle3.getCircumference());

        System.out.println("Distance between circle1 and circle2: " + circle1.distance(circle2));
        System.out.println("Circle2 center X: " + circle2.getCenterX());
        System.out.println("Circle2 center Y: " + circle2.getCenterY());
        circle2.setCenterXY(11, 12);
        System.out.println("New center of circle2: " + circle2.getCenterXY()[0] + ", " + circle2.getCenterXY()[1]);
    }
}
