package Ex8;
public class Test {
    public static void main(String[] args) {
        MyIntStack stack = new MyIntStack(3);

        System.out.println("Pushing elements onto the stack:");
        System.out.println("Push 10: " + stack.push(10));
        System.out.println("Push 20: " + stack.push(20));
        System.out.println("Push 30: " + stack.push(30));
        System.out.println("Push 40: " + stack.push(40));

        System.out.println("\nTop of the stack (peek): " + stack.peek());
        System.out.println("\nPopping elements from the stack:");
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        try {
            System.out.println("Pop: " + stack.pop());
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println("\nIs the stack empty? " + stack.isEmpty());
    }
}
