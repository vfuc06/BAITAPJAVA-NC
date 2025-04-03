package ThreadTicket;
public class TicketSaleProblem {
    Store store;
    TicketAgent ticketAgent;
    Branch[] branches;
    Customer[] customers;
    public TicketSaleProblem(int numBranches, int numCustomers) {
        store = new Store();
        ticketAgent = new TicketAgent(store);

        branches = new Branch[numBranches];
        for (int i = 0; i < numBranches; i++) {
            branches[i] = new Branch(store, i + 1);
            branches[i].start();
        }

        customers = new Customer[numCustomers];
        for (int i = 0; i < numCustomers; i++) {
            customers[i] = new Customer(store, branches);
            customers[i].start();
        }
        ticketAgent.start();
    }
    public static void main(String args[]) {
        int numBranches = 3;
        int numCustomers = 5;
        new TicketSaleProblem(numBranches, numCustomers);
    }
}