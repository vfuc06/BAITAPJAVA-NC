package ThreadBread;
public class Customer extends Thread {
    Store store;
    public Customer(Store s) {
        store = s;
    }
    public void run() {
        while (true) {
            try {
                long bread = store.get();
                if (bread > 0) {
                    System.out.println("-- Bread " + bread + " is bought.");
                } else {
                    System.out.println("Customer is waiting for bread.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}