package Ex6_5;
public class TestResizableCircle {
    public static void main(String[] args) {
        ResizableCircle resizableCircle = new ResizableCircle(5.0);
        System.out.println(resizableCircle);
        System.out.println("Area before resize: " + resizableCircle.getArea());
        System.out.println("Perimeter before resize: " + resizableCircle.getPerimeter());
        resizableCircle.resize(50);
        System.out.println("After resizing by 50%: " + resizableCircle);
        System.out.println("Area after resize: " + resizableCircle.getArea());
        System.out.println("Perimeter after resize: " + resizableCircle.getPerimeter());
    }
}
