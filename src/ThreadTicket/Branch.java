package ThreadTicket;
class Branch extends Thread {
    Store store;
    int branchId;
    public Branch(Store s, int id) {
        store = s;
        branchId = id;
    }
    public void run() {
        while (true) {
            try {
                long ticket = store.getRandomTicket();
                if (ticket > 0) {
                    System.out.println("Chi nhánh " + branchId + ": Vé tàu " + ticket + " đã được bán.");
                } else {
                    System.out.println("Chi nhánh " + branchId + " đang chờ vé mới từ đại lý.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}