package ThreadBread;
public class ProducerConsumerProblem {
    Store store;
    Producer supplier;
    Customer customer;
    public ProducerConsumerProblem() {
        store = new Store();
        supplier = new Producer(store);
        customer = new Customer(store);
        supplier.start();
        customer.start();
    }

    public static void main(String args[]) {
        new ProducerConsumerProblem(); // Start the simulation
    }
}