package TH060325;
public class ThreadPriority {
    public static void main(String[] args) {
        Thread highPiorityThread = new Thread(()->{
           while(true){
               System.out.println("High Priority thread is running");
//               Thread.yield();//Nhường CPU cho luồng khác
           }
        });
        Thread lowPriorityThread = new Thread(()->{
            while(true){
                System.out.println("Low Priority thread is running");
            }
        });
        highPiorityThread.setPriority(Thread.MAX_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
        highPiorityThread.start();
        lowPriorityThread.start();
    }
}
