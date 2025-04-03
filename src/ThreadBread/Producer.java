package ThreadBread;
public class Producer extends Thread {
    Store store;
    long index = 1;
    public Producer(Store s) {
        store = s;
    }
    public void run() {
        while (true) {
            try {
                boolean result = store.put(index);
                if (result) {
                    System.out.println("** Bread " + (index++) + " is produced.");
                } else {
                    System.out.println("Store is full, no more bread can be produced!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}