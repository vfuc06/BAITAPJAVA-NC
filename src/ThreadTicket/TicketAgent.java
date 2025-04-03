package ThreadTicket;
class TicketAgent extends Thread {
    Store store;
    long ticketIndex = 1;
    public TicketAgent(Store s) {
        store = s;
    }
    public void run() {
        while (true) {
            try {
                boolean result = store.put(ticketIndex);
                if (result) {
                    System.out.println("** Vé tàu " + (ticketIndex++) + " đã được phát hành.");
                } else {
                    System.out.println("Cửa hàng vé tàu đã đầy, không thể phát hành thêm vé!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}