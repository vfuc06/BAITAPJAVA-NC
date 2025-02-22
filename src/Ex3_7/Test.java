package Ex3_7;
public class Test {
    public static void main(String[] args) {
        Ball ball = new Ball(50, 50, 0);
        Player player1 = new Player(7, 48, 48);
        Player player2 = new Player(10, 60, 60);

        System.out.println("Initial Ball Position: " + ball);

        player1.kick(ball);
        System.out.println("Ball Position after Player 1 kicks: " + ball);

        player2.move(-5, -5);
        player2.kick(ball);
        System.out.println("Ball Position after Player 2 kicks: " + ball);
    }

}
