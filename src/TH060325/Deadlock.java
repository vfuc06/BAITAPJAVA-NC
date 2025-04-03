package TH060325;
class Resource{}
public class Deadlock {
    public static void main(String[] args) {
        Resource resource1 = new Resource();
        Resource resource2 = new Resource();
        Thread t1 = new Thread(()->{
            synchronized (resource1){
                System.out.println("Thread 1 locked resource 1");
//                try{
//                    Thread.sleep(10000);
//                }
//                catch (InterruptedException e){}
                synchronized (resource2){
                    System.out.println("Thread 1 locked resource 2");
                }
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (resource1){
                System.out.println("Thread 2 locked resource 2");
//                try {
//                    Thread.sleep(10000);
//                }
//                catch (InterruptedException e){}
                synchronized (resource2){
                    System.out.println("Thread 2 locked resource 1");
                }
            }
        });
        t1.start();
        t2.start();
    }
    
}
