package Ex6_4;
public class Test {
    public static void main(String[] args) {
        MovableCircle circle = new MovableCircle(0, 0, 2, 3, 5);
        System.out.println("Initial Position: " + circle);
        circle.moveUp();
        System.out.println("After moveUp: " + circle);
        circle.moveDown();
        System.out.println("After moveDown: " + circle);
        circle.moveLeft();
        System.out.println("After moveLeft: " + circle);
        circle.moveRight();
        System.out.println("After moveRight: " + circle);
    }
}
