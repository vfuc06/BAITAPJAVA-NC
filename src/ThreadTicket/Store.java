package ThreadTicket;
import java.util.Random;
public class Store {
    int maxN = 50;
    long[] tickets;
    int n;

    public Store() {
        n = 0;
        tickets = new long[maxN];
    }
    private boolean empty() {
        return n == 0;
    }
    private boolean full() {
        return n == maxN;
    }
    public synchronized boolean put(long ticket) {
        if (full()) {
            return false;
        }

        tickets[n++] = ticket;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return true;
    }
    public synchronized long getRandomTicket() {
        long result = 0;
        if (!empty()) {
            Random random = new Random();
            // Chọn ngẫu nhiên một vé từ cửa hàng
            int index = random.nextInt(n);
            result = tickets[index];
            for (int i = index; i < n - 1; i++) {
                tickets[i] = tickets[i + 1];
            }
            n--;
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return result;
    }
}