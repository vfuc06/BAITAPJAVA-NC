package Ex2_6to2_9;
public class TestMyLine {
    public static void main(String[] args) {
        MyLine line1 = new MyLine(1, 2, 4, 6);
        System.out.println(line1);

        System.out.println("Begin X: " + line1.getBeginX());
        System.out.println("Begin Y: " + line1.getBeginY());

        line1.setBeginX(0);
        line1.setBeginY(0);
        line1.setEndX(3);
        line1.setEndY(4);
        System.out.println(line1);

        System.out.println("Length of the line: " + line1.getLength());
        System.out.println("Gradient of the line: " + line1.getGradient());

        MyPoint p1 = new MyPoint(2, 3);
        MyPoint p2 = new MyPoint(5, 7);
        MyLine line2 = new MyLine(p1, p2);
        System.out.println(line2);
        System.out.println("Begin XY: (" + line2.getBeginXY()[0] + ", " + line2.getBeginXY()[1] + ")");
        System.out.println("End XY: (" + line2.getEndXY()[0] + ", " + line2.getEndXY()[1] + ")");
    }
}
