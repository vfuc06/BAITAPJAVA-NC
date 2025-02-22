package Ex5_1;
public class Line {
    private Point begin;
    private Point end;

    public Line(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    public Line(int beginX, int beginY, int endX, int endY) {
        this.begin = new Point(beginX, beginY);
        this.end = new Point(endX, endY);
    }

    public Point getBegin() { return begin; }
    public Point getEnd() { return end; }
    public void setBegin(Point begin) { this.begin = begin; }
    public void setEnd(Point end) { this.end = end; }

    public int getBeginX() { return begin.getX(); }
    public int getBeginY() { return begin.getY(); }
    public int getEndX() { return end.getX(); }
    public int getEndY() { return end.getY(); }

    public void setBeginXY(int x, int y) { begin.setXY(x, y); }
    public void setEndXY(int x, int y) { end.setXY(x, y); }

    public double getLength() {
        int xDiff = end.getX() - begin.getX();
        int yDiff = end.getY() - begin.getY();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public double getGradient() {
        int xDiff = end.getX() - begin.getX();
        int yDiff = end.getY() - begin.getY();
        return Math.atan2(yDiff, xDiff);
    }

    public String toString() {
        return "Line: " + begin + " to " + end;
    }
}
