package Ex6_3;

public class Test {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0, 0, 2, 3);
        System.out.println("Initial Position: " + point);
        point.moveUp();
        System.out.println("After moveUp: " + point);
        point.moveDown();
        System.out.println("After moveDown: " + point);
        point.moveLeft();
        System.out.println("After moveLeft: " + point);
        point.moveRight();
        System.out.println("After moveRight: " + point);
    }
}
