package TH060325;

public class ThreadInterruption {
    public static void main(String[] args) {
        Thread iLoopThread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is running");
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted");
                    break;
                }
            }
            System.out.println("Thread has stopped");
        });
        iLoopThread.start();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {}
        iLoopThread.interrupt();
    }
}
