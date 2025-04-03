package TH060325;
public class MemoryVisibleFix {
    static volatile  boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while(!flag){}
                System.out.println("Thread 1 phát hiện đổi cờ thành true");
        });
        Thread t2 = new Thread(()->{
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException ignore){}
            flag = true;
            System.out.println("Thread 2 đã thay đổi cờ thành true");
        });
        t1.start();
        t2.start();
    }
}
