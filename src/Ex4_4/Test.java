package Ex4_4;

public class Test {
    public static void main(String[] args) {
        MovablePoint mp = new MovablePoint(2, 3, 1, 1);
        System.out.println("Before move: " + mp);
        mp.move();
        System.out.println("After move: " + mp);
    }
}
