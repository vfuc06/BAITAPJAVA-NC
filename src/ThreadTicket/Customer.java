package ThreadTicket;
import java.util.Random;
public class Customer extends Thread {
    Store store;
    Branch[] branches;
    public Customer(Store s, Branch[] branches) {
        store = s;
        this.branches = branches;
    }
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                int branchIndex = random.nextInt(branches.length);
                long ticket = branches[branchIndex].store.getRandomTicket();
                if (ticket > 0) {
                    System.out.println("Khách hàng đã mua vé tàu " + ticket + " từ chi nhánh " + (branchIndex + 1));
                } else {
                    System.out.println("Khách hàng đang chờ vé mới từ chi nhánh " + (branchIndex + 1));
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}