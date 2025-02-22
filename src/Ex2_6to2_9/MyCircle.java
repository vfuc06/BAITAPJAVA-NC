package Ex2_6to2_9;

public class MyCircle {
        private MyPoint center; // Tâm của hình tròn, kiểu MyPoint
        private int radius;     // Bán kính của hình tròn

        public MyCircle() {
            this.center = new MyPoint(0, 0); // Tâm ở (0,0)
            this.radius = 1;                 // Bán kính = 1
        }

        public MyCircle(int x, int y, int radius) {
            this.center = new MyPoint(x, y); // Tạo đối tượng MyPoint cho tâm
            this.radius = radius;            // Gán bán kính
        }

        public MyCircle(MyPoint center, int radius) {
            this.center = center;            // Sử dụng MyPoint đã được tạo sẵn
            this.radius = radius;            // Gán bán kính
        }

        public int getRadius() {
            return radius;
        }
        public void setRadius(int radius) {
            this.radius = radius;
        }

        public MyPoint getCenter() {
            return center;
        }
        public void setCenter(MyPoint center) {
            this.center = center;
        }

        public int getCenterX() {
            return center.getX();
        }
        public void setCenterX(int x) {
            center.setX(x);
        }

        public int getCenterY() {
            return center.getY();
        }
        public void setCenterY(int y) {
            center.setY(y);
        }

        public int[] getCenterXY() {
            return center.getXY();
        }
        public void setCenterXY(int x, int y) {
            center.setXY(x, y);
        }

        public double getArea() {
            return Math.PI * radius * radius; // Công thức diện tích: π * r^2
        }

        public double getCircumference() {
            return 2 * Math.PI * radius; // Công thức chu vi: 2 * π * r
        }

        public double distance(MyCircle another) {
            return center.distance(another.center); // Sử dụng phương thức distance() của MyPoint
        }

        @Override
        public String toString() {
            return "MyCircle [radius=" + radius + ", center=" + center + "]";
        }

}
