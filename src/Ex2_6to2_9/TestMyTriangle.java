package Ex2_6to2_9;

public class TestMyTriangle {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(0, 0);
        MyPoint p2 = new MyPoint(3, 0);
        MyPoint p3 = new MyPoint(0, 4);

        MyTriangle triangle1 = new MyTriangle(p1, p2, p3);

        System.out.println(triangle1);

        System.out.println("Perimeter of triangle: " + triangle1.getPerimeter());

        System.out.println("Type of triangle: " + triangle1.getType());

        MyPoint p4 = new MyPoint(0, 0);
        MyPoint p5 = new MyPoint(1, 1);
        MyPoint p6 = new MyPoint(2, 0);
        MyTriangle triangle2 = new MyTriangle(p4, p5, p6);
        System.out.println("Type of triangle2: " + triangle2.getType());

        MyPoint p7 = new MyPoint(0, 0);
        MyPoint p8 = new MyPoint(5, 0);
        MyPoint p9 = new MyPoint(2, 4);
        MyTriangle triangle3 = new MyTriangle(p7, p8, p9);
        System.out.println("Type of triangle3: " + triangle3.getType());

        MyPoint p10 = new MyPoint(1, 1);
        MyPoint p11 = new MyPoint(5, 1);
        MyPoint p12 = new MyPoint(3, 5);
        MyTriangle triangle4 = new MyTriangle(p10, p11, p12);
        System.out.println("Type of triangle4: " + triangle4.getType());
    }
}
