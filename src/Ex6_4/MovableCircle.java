package Ex6_4;
public class MovableCircle implements Movable {
    int radius;
    MovablePoint center;
    int xSpeed;
    int ySpeed;
    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }
    @Override
    public void moveUp() {
        center.moveUp(); // Move the center of the circle up
    }
    @Override
    public void moveDown() {
        center.moveDown(); // Move the center of the circle down
    }
    @Override
    public void moveLeft() {
        center.moveLeft(); // Move the center of the circle left
    }
    @Override
    public void moveRight() {
        center.moveRight(); // Move the center of the circle right
    }
    @Override
    public String toString() {
        return center.toString() + ", radius=" + radius;
    }
}
