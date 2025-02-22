package Ex7_1;
public class Test {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice");
        customer1.setMember(true);
        customer1.setMemberType("Premium");
        customer1.setServiceExpense(100);
        customer1.setProductExpense(200);
        Customer customer2 = new Customer("Bob");
        customer2.setMember(true);
        customer2.setMemberType("Gold");
        customer2.setServiceExpense(150);
        customer2.setProductExpense(100);
        Customer customer3 = new Customer("Charlie");
        customer3.setMember(false);
        customer3.setServiceExpense(120);
        customer3.setProductExpense(80);

        Visit visit1 = new Visit(customer1);
        Visit visit2 = new Visit(customer2);
        Visit visit3 = new Visit(customer3);

        System.out.println(visit1);
        System.out.println(visit2);
        System.out.println(visit3);
    }
}
