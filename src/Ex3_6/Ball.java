package Ex3_6;
public class Ball {
        private float x, y, xDelta, yDelta;
        private int radius;

        public Ball(int x, int y, int radius, int speed, int direction) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            double radian = Math.toRadians(direction);
            this.xDelta = (float) (speed * Math.cos(radian));
            this.yDelta = (float) (-speed * Math.sin(radian));
        }

        public int getX() { return (int) x; }
        public int getY() { return (int) y; }
        public int getRadius() { return radius; }
        public int getXDelta() { return (int) xDelta; }
        public int getYDelta() { return (int) yDelta; }

        public void setX(int x) { this.x = x; }
        public void setY(int y) { this.y = y; }
        public void setRadius(int radius) { this.radius = radius; }
        public void setXDelta(int xDelta) { this.xDelta = xDelta; }
        public void setYDelta(int yDelta) { this.yDelta = yDelta; }
        public void move() {
            x += xDelta;
            y += yDelta;
        }
        public void reflectHorizontal() {
            xDelta = -xDelta;
        }
        public void reflectVertical() {
            yDelta = -yDelta;
        }
        @Override
        public String toString() {
            return "Ball at (" + x + ", " + y + ") of velocity (" + xDelta + ", " + yDelta + ")";
        }
}
