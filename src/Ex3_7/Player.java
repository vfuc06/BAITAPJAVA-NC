package Ex3_7;

public class Player {
    private int number;
    private float x, y, z = 0.0f;

    public Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void move(float xDisp, float yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    public void jump(float zDisp) {
        this.z += zDisp;
    }

    public boolean near(Ball ball) {
        return Math.sqrt(Math.pow(this.x - ball.getX(), 2) + Math.pow(this.y - ball.getY(), 2)) < 8;
    }

    public void kick(Ball ball) {
        if (near(ball)) {
            ball.setXYZ(ball.getX() + 5, ball.getY() + 5, ball.getZ() + 2);
        }
    }
}
